package thermodynamicSimulator;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.event.*;

/**
 * 
 * @author yaqin
 * Purpose: Left side scroll lists 
 */
public class HeatList extends JPanel implements ListSelectionListener
{
	private static final long serialVersionUID = 1L;
	private static final String addString = "ADD", removeString = "REMOVE";
	
	public static HashMap<String, Heat> heatMap = new HashMap<>();
	public static JList<String> list;
	public static DefaultListModel<String> listModel;
	
	private static JButton removeButton;
	private static JTextField heatField;

	public HeatList()
	{
		super(null);
		listModel = new DefaultListModel<>();
		listModel.addElement("Default");
		list = new JList<>(listModel);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setSelectedIndex(0);
		list.addListSelectionListener(this);
		list.setVisibleRowCount(JList.VERTICAL);
		list.setFont(new Font("Arial", Font.BOLD, 24));
		JScrollPane listScrollPane = new JScrollPane(list);
		
		JButton addButton = new JButton(addString);
		AddListener addListener = new AddListener(addButton);
		addButton.setActionCommand(addString);
		addButton.addActionListener(addListener);
		addButton.setEnabled(false);
		
		removeButton = new JButton(removeString);
		removeButton.setActionCommand(removeString);
		removeButton.addActionListener(new RemoveListener());
		
		heatField = new JTextField();
		heatField.addActionListener(addListener);
		heatField.getDocument().addDocumentListener(addListener);
		
		
		JPanel buttonPane = new JPanel();
		buttonPane.setLayout(new BoxLayout(buttonPane, BoxLayout.LINE_AXIS));
		buttonPane.add(removeButton);
		buttonPane.add(Box.createHorizontalStrut(5));
		buttonPane.add(addButton);
		
		JPanel fieldPane = new JPanel();
		fieldPane.setLayout(new BoxLayout(fieldPane, BoxLayout.Y_AXIS));
		fieldPane.add(buttonPane);
		fieldPane.add(Box.createVerticalStrut(5));
		fieldPane.add(heatField);
		fieldPane.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		
		listScrollPane.setBounds(0, 0, 200, 500);
		fieldPane.setBounds(0, 500, 200, 70);
		add(listScrollPane);
		add(fieldPane);
	}
	
	class AddListener implements ActionListener, DocumentListener
	{
		private JButton button;
		private boolean isEnabled = false;
		
		public AddListener(JButton button)
		{
			this.button = button;
		}
		public void insertUpdate(DocumentEvent e) { enableButton(); } 
		public void removeUpdate(DocumentEvent e) { handleEmptyField(e); } 
		public void changedUpdate(DocumentEvent e) { if(!handleEmptyField(e)) { enableButton(); } } 
		public void actionPerformed(ActionEvent e)
		{
			String name = heatField.getText();
			if(name.equals("") || name.startsWith(" ") || alreadyInList(name))
			{
				Toolkit.getDefaultToolkit().beep();
				heatField.requestFocusInWindow();
				heatField.selectAll();
				return;
			}
			int index = list.getSelectedIndex();
			if(index == -1) { index = 0; } else { index++; }
			heatMap.put(name, new Heat(name));
			listModel.insertElementAt(name, index);
			heatField.requestFocusInWindow();
			heatField.setText("");
			list.setSelectedIndex(index);
			list.ensureIndexIsVisible(index);
		}
		protected boolean alreadyInList(String name) { return listModel.contains(name); }
		private void enableButton() { if(!isEnabled) { button.setEnabled(true); } }
		private boolean handleEmptyField(DocumentEvent e)
		{
			if(e.getDocument().getLength() <=0)
			{
				button.setEnabled(false);
				isEnabled = false;
				return true;
			}
			return false;
		}
		
		
	}
	
	class RemoveListener implements ActionListener
	{

		public void actionPerformed(ActionEvent e)
		{
			int index = list.getSelectedIndex();
			String name = list.getSelectedValue();
			if(index == 0) { return; }
			if(JOptionPane.showOptionDialog(Main.frame, "Are you sure you want to delete the force '" + name + "'?", "Delete this Force?", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, null, null, null) == JOptionPane.NO_OPTION) { return; }
			heatMap.remove(name);
			listModel.remove(index);
			int size = listModel.getSize();
			if(size == 0) { removeButton.setEnabled(false); }
			else
			{
				if(index == listModel.getSize()) { index--; }
				list.setSelectedIndex(index);
				list.ensureIndexIsVisible(index);
			}
		}
		
		
	}
	@Override
	public void valueChanged(ListSelectionEvent e)
	{
		int index = list.getSelectedIndex();
			
		Main.screenPanel.setVisible(false);
		Main.screenPanel.removeAll();
		HeatPanel heatPanel = null;
		if(index > 0)
		{
			String name = list.getSelectedValue();
			heatPanel = new HeatPanel(heatMap.get(name));
			Main.screenPanel.add(heatPanel);
		} else {
		}
		
		Main.screenPanel.add(new HeatEnergyPanel());
		Main.screenPanel.revalidate();
		Main.screenPanel.repaint();
		Main.screenPanel.setVisible(true);
		
	}
	
}
