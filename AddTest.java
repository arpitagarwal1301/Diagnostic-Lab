import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

class AddTest extends JFrame implements ActionListener
{
	JLabel addTestEntry,testDepartment,testCategory,testGroup,testName,rate,normalValue;
	JButton ok,cancel;
	JTextField tRate,tNormalValue,tTestName;
	JComboBox cTestDepartment,cTestCategory,cTestGroup;
	Container content;
	JPanel pHead,pCenter,pWest;
	String dept_name=null;
	String cat_name=null;
	String group_name=null;
	int cat_id=0;
	int dept_id=0;
	int group_id=0;
	Connection con;
	public AddTest()
	{
		
		setSize((int)(Toolkit.getDefaultToolkit().getScreenSize().getWidth()),(int)(Toolkit.getDefaultToolkit().getScreenSize().getHeight())-40);
		setResizable(false);
		setTitle("Add Test");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		pHead=new JPanel(new FlowLayout(FlowLayout.CENTER));
   		pHead.setBackground(new Color(134,134,234));
		pCenter=new JPanel(new GridBagLayout());
    	pCenter.setBackground(new Color(211,248,253));
    	pWest=new JPanel(new GridBagLayout());
    	pWest.setBackground(new Color(211,248,253));

		addTestEntry=new JLabel("ADD TEST ENTRY");
    	addTestEntry.setForeground(Color.WHITE);
    	Font f2=new Font("Papyrus",Font.BOLD,36);
    	addTestEntry.setFont(f2);
		testDepartment=new JLabel("Test Department");
    	Font f1=new Font("Goudy Old Style",Font.BOLD,16);
    	testDepartment.setFont(f1);
		testCategory=new JLabel("Test Category");
    	testCategory.setFont(f1);
		testGroup=new JLabel("Test Group");
    	testGroup.setFont(f1);
		testName=new JLabel("Test Name");
    	testName.setFont(f1);
		rate=new JLabel("Rate");
    	rate.setFont(f1);
		normalValue=new JLabel("Normal Value");
    	normalValue.setFont(f1);

		tRate=new JTextField();
		tNormalValue=new JTextField();
		tTestName=new JTextField();

		ok=new JButton("OK");
    	ok.setFont(f1);
		cancel=new JButton("BACK");
    	cancel.setFont(f1);


		cTestDepartment=new JComboBox();
		cTestCategory=new JComboBox();
		cTestGroup=new JComboBox();
		
	//Adding Icon on top-left.
	ImageIcon img = new ImageIcon("pics/logo.jpg");
	this.setIconImage(img.getImage());

		content=getContentPane();

  //Adding image in West panel
    Icon i=new ImageIcon("pics/Test1.png");
    JLabel l1=new JLabel(i);
    GridBagConstraints gc=new GridBagConstraints();
    gc.fill = GridBagConstraints.NONE;
    gc.gridx = 1;
    gc.gridwidth = 1;
    gc.gridy = 1;
    gc.ipadx = 20;
    gc.ipady = 0;
    gc.weightx = 0;
    gc.weighty = 0;
    gc.anchor = GridBagConstraints.NORTH;
    gc.insets=new Insets(0,0,20,0);
    pWest.add(l1,gc);



		//for label testDepartment
    gc=new GridBagConstraints();
		gc.fill = GridBagConstraints.NONE;
		gc.gridx = 1;
		gc.gridwidth = 1;
		gc.gridy = 1;
		gc.ipadx = 20;
		gc.ipady = 0;
		gc.weightx = 0;
		gc.weighty = 0;
		gc.anchor = GridBagConstraints.WEST;
		gc.insets=new Insets(0,0,20,0);
		pCenter.add(testDepartment,gc);


		//for combo box cTestDepartment
		gc=new GridBagConstraints();
		cTestDepartment.addItem("select department");
		cTestDepartment.addActionListener(this);
		gc.fill = GridBagConstraints.NONE;
		gc.gridx = 2;
		gc.gridwidth = 1;
		gc.gridy = 1;
		gc.ipadx = 100;
		gc.ipady = 0;
		gc.weightx = 0;
		gc.weighty = 0;
		gc.anchor = GridBagConstraints.WEST;
		gc.insets=new Insets(0,0,20,0);
		pCenter.add(cTestDepartment,gc);
		
		try
		{
			con=JDBCConnection.getConnection();
			PreparedStatement pstmt=con.prepareStatement("select dept_name from department");
			ResultSet rs=pstmt.executeQuery();
			while(rs.next())
			{
				cTestDepartment.addItem(rs.getString("dept_name"));
			}

		}
		catch(SQLException se)
		{
			se.printStackTrace();
		}

		//for label testCategory
		gc=new GridBagConstraints();
		gc.fill = GridBagConstraints.NONE;
		gc.gridx = 3;
		gc.gridwidth = 1;
		gc.gridy = 1;
		gc.ipadx = 20;
		gc.ipady = 0;
		gc.weightx = 0;
		gc.weighty = 0;
		gc.anchor = GridBagConstraints.WEST;
		gc.insets=new Insets(0,20,20,0);
		pCenter.add(testCategory,gc);

		//for Combo box cTestCategory
		gc=new GridBagConstraints();
		cTestCategory.addItem("select Category");
		gc.fill = GridBagConstraints.NONE;
		gc.gridx = 4;
		gc.gridwidth = 1;
		gc.gridy = 1;
		gc.ipadx = 100;
		gc.ipady = 0;
		gc.weightx = 0;
		gc.weighty = 0;
		gc.anchor = GridBagConstraints.WEST;
		gc.insets=new Insets(0,0,20,0);
		pCenter.add(cTestCategory,gc);
		cTestCategory.addActionListener(this);



		//for label testGroup
		gc=new GridBagConstraints();
		gc.fill = GridBagConstraints.NONE;
		gc.gridx = 1;
		gc.gridwidth = 1;
		gc.gridy = 2;
		gc.ipadx = 20;
		gc.ipady = 0;
		gc.weightx = 0;
		gc.weighty = 0;
		gc.anchor = GridBagConstraints.WEST;
		gc.insets=new Insets(0,0,20,0);
		pCenter.add(testGroup,gc);

		//for combo box cTestGroup
		gc=new GridBagConstraints();
		cTestGroup.addItem("select Group");
		gc.fill = GridBagConstraints.NONE;
		gc.gridx = 2;
		gc.gridwidth = 1;
		gc.gridy = 2;
		gc.ipadx = 100;
		gc.ipady = 0;
		gc.weightx = 0;
		gc.weighty = 0;
		gc.anchor = GridBagConstraints.WEST;
		gc.insets=new Insets(0,0,20,0);
		pCenter.add(cTestGroup,gc);
		cTestGroup.addActionListener(this);




		//for label testName
		gc=new GridBagConstraints();
		gc.fill = GridBagConstraints.NONE;
		gc.gridx = 3;
		gc.gridwidth = 1;
		gc.gridy = 2;
		gc.ipadx = 20;
		gc.ipady = 0;
		gc.weightx = 0;
		gc.weighty = 0;
		gc.anchor = GridBagConstraints.WEST;
		gc.insets=new Insets(0,20,20,0);
		pCenter.add(testName,gc);

			//for label tTestName
		gc=new GridBagConstraints();
		gc.fill = GridBagConstraints.NONE;
		gc.gridx = 4;
		gc.gridwidth = 1;
		gc.gridy = 2;
		gc.ipadx = 100;
		gc.ipady = 0;
		gc.weightx = 0;
		gc.weighty = 0;
		gc.anchor = GridBagConstraints.WEST;
		gc.insets=new Insets(0,0,20,0);
		pCenter.add(tTestName,gc);

				//for label rate
		gc=new GridBagConstraints();
		gc.fill = GridBagConstraints.NONE;
		gc.gridx = 1;
		gc.gridwidth = 1;
		gc.gridy = 3;
		gc.ipadx = 20;
		gc.ipady = 0;
		gc.weightx = 0;
		gc.weighty = 0;
		gc.anchor = GridBagConstraints.WEST;
		gc.insets=new Insets(0,0,20,0);
		pCenter.add(rate,gc);



		//for label tRate
		gc=new GridBagConstraints();
		gc.fill = GridBagConstraints.NONE;
		gc.gridx = 2;
		gc.gridwidth = 1;
		gc.gridy = 3;
		gc.ipadx = 100;
		gc.ipady = 0;
		gc.weightx = 0;
		gc.weighty = 0;
		gc.anchor = GridBagConstraints.WEST;
		gc.insets=new Insets(0,0,20,0);
		pCenter.add(tRate,gc);

		//for label normalValue
		gc=new GridBagConstraints();
		gc.fill = GridBagConstraints.NONE;
		gc.gridx = 3;
		gc.gridwidth = 1;
		gc.gridy = 3;
		gc.ipadx = 20;
		gc.ipady = 0;
		gc.weightx = 0;
		gc.weighty = 0;
		gc.anchor = GridBagConstraints.WEST;
		gc.insets=new Insets(0,20,20,0);
		pCenter.add(normalValue,gc);

			//for label tNormalValue
		gc=new GridBagConstraints();
		gc.fill = GridBagConstraints.NONE;
		gc.gridx = 4;
		gc.gridwidth = 1;
		gc.gridy = 3;
		gc.ipadx = 100;
		gc.ipady = 0;
		gc.weightx = 0;
		gc.weighty = 0;
		gc.anchor = GridBagConstraints.WEST;
		gc.insets=new Insets(0,0,20,0);
		pCenter.add(tNormalValue,gc);

			//for label ok
		gc=new GridBagConstraints();
		gc.fill = GridBagConstraints.NONE;
		gc.gridx = 2;
		gc.gridwidth = 1;
		gc.gridy = 4;
		gc.ipadx = 50;
		gc.ipady = 0;
		gc.weightx = 0;
		gc.weighty = 0;
		gc.anchor = GridBagConstraints.WEST;
		gc.insets=new Insets(0,0,20,0);
		pCenter.add(ok,gc);
		ok.addActionListener(this);

				//for label cancel
		gc=new GridBagConstraints();
		gc.fill = GridBagConstraints.NONE;
		gc.gridx = 3;
		gc.gridwidth = 2;
		gc.gridy = 4;
		gc.ipadx = 20;
		gc.ipady = 0;
		gc.weightx = 0;
		gc.weighty = 0;
		gc.anchor = GridBagConstraints.WEST;
		gc.insets=new Insets(0,20,20,0);
		pCenter.add(cancel,gc);
		cancel.addActionListener(this);
		pHead.add(addTestEntry);

		//pCenter.setBackground(new Color())
		content.add(pHead,BorderLayout.NORTH);
		content.add(pCenter,BorderLayout.CENTER);
      content.add(pWest,BorderLayout.WEST);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent ae)
	{

		if(ae.getSource()==cTestDepartment)
		{
			try
			{
				dept_name=String.valueOf(cTestDepartment.getSelectedItem());
				con =JDBCConnection.getConnection();
				PreparedStatement pstmt=con.prepareStatement("select dept_id from department where dept_name=?");
				pstmt.setString(1,dept_name);
				ResultSet rs=pstmt.executeQuery();
				if(rs.next())
				{
					dept_id=rs.getInt("dept_id");
				}
			}	
			catch(SQLException qe)
			{
				qe.printStackTrace();
		
			}
			try
			{
				con=JDBCConnection.getConnection();
				cTestCategory.removeAllItems();
				cTestCategory.addItem("select Category");
				PreparedStatement pstmt=con.prepareStatement("select cat_name from category where dept_id=?");
				pstmt.setInt(1,dept_id);
				ResultSet rs=pstmt.executeQuery();
				while(rs.next())
				{
					cTestCategory.addItem(rs.getString("cat_name"));
				}	
			}
			catch(SQLException se)
			{
				se.printStackTrace();
			}
	
		}

		if(ae.getSource()==cTestCategory)
		{

			try
			{
				cat_name=String.valueOf(cTestCategory.getSelectedItem());
				con =JDBCConnection.getConnection();
				PreparedStatement pstmt=con.prepareStatement("select cat_id from category where cat_name=?");
				pstmt.setString(1,cat_name);
				ResultSet rs=pstmt.executeQuery();
				if(rs.next())
				{
						cat_id=rs.getInt("cat_id");
				}
			}
			catch(SQLException sq)
			{
				sq.printStackTrace();
			}
			try
			{
				con=JDBCConnection.getConnection();
				cTestGroup.removeAllItems();
				cTestGroup.addItem("select Group");
				PreparedStatement pstmt=con.prepareStatement("select GROUP_NAME from addgroup where cat_id=? and dept_id=?");
				pstmt.setInt(1,cat_id);
				pstmt.setInt(2,dept_id);
				ResultSet rs=pstmt.executeQuery();
				while(rs.next())
				{
					cTestGroup.addItem(rs.getString("GROUP_NAME"));
				}
			}
			catch(SQLException se)
			{
				se.printStackTrace();
			}
	
	
		}
		if(ae.getSource()==cTestGroup)
		{

		try
		{
			group_name=String.valueOf(cTestGroup.getSelectedItem());
			con =JDBCConnection.getConnection();
			PreparedStatement pstmt=con.prepareStatement("select group_id from addgroup where group_name=?");
			pstmt.setString(1,group_name);
			ResultSet rs=pstmt.executeQuery();
			if(rs.next())
			{
				group_id=rs.getInt("group_id");
			}
		}
		catch(SQLException sq)
		{
			sq.printStackTrace();
		}
	}
		if(ae.getSource()==ok)
		{
			if(String.valueOf(cTestDepartment.getSelectedItem()).equals("select department"))
			{
				JOptionPane.showMessageDialog(this,"Department field must not be Empty","Warning",JOptionPane.WARNING_MESSAGE);
				tNormalValue.setText(null);
				tRate.setText(null);
				tTestName.setText(null);
				return;
			}
			if(String.valueOf(cTestCategory.getSelectedItem()).equals("select Category"))
			{
				JOptionPane.showMessageDialog(this,"Category field must not be Empty","Warning",JOptionPane.WARNING_MESSAGE);
				tNormalValue.setText(null);
				tRate.setText(null);
				tTestName.setText(null);
				return;
			}

			if(String.valueOf(cTestGroup.getSelectedItem()).equals("select Group"))
			{
				JOptionPane.showMessageDialog(this,"Category field must not be Empty","Warning",JOptionPane.WARNING_MESSAGE);
				tNormalValue.setText(null);
				tRate.setText(null);
				tTestName.setText(null);
				return;
			}


			if(tNormalValue.getText().equals(""))
			{
				JOptionPane.showMessageDialog(this,"Enter the Normal Value !!","Warning",JOptionPane.WARNING_MESSAGE);
				return;
			}

			if(tRate.getText().equals(""))
			{
				JOptionPane.showMessageDialog(this,"Enter the TEst Rate !!","Warning",JOptionPane.WARNING_MESSAGE);
				return;
			}

			if(tTestName.getText().equals(""))
			{
				JOptionPane.showMessageDialog(this,"Enter nmae of the test !!","Warning",JOptionPane.WARNING_MESSAGE);
				return;
			}

			try
			{
			  	con=JDBCConnection.getConnection();
				PreparedStatement pstmt=con.prepareStatement("select test_name from addtest where group_id=? and cat_id=? and dept_id=?");
				pstmt.setInt(1,group_id);
				pstmt.setInt(2,cat_id);
				pstmt.setInt(3,dept_id);
				ResultSet rs=pstmt.executeQuery();
				while(rs.next())
				{
					if(tTestName.getText().equals(rs.getString("test_name")))
					{
						JOptionPane.showMessageDialog(this,"Test name already exists!!","Warning",JOptionPane.WARNING_MESSAGE);
						tNormalValue.setText(null);
						tRate.setText(null);
						tTestName.setText(null);
						return;
					}
				}
			}
			catch(SQLException p)
			{
				p.printStackTrace();
			}
			try
			{
			    con=JDBCConnection.getConnection();
			    String query="insert into AddTest values(test_id.nextval,?,?,?,?,?,?)";
				PreparedStatement pstmt=con.prepareStatement(query);
				pstmt.setInt(1,group_id);
				pstmt.setInt(2,cat_id);
				pstmt.setInt(3,dept_id);
				pstmt.setString(4,tRate.getText());
				pstmt.setString(5,tNormalValue.getText());
				pstmt.setString(6,tTestName.getText());
				int a=pstmt.executeUpdate();
				if(a>0)
				{
					JOptionPane.showMessageDialog(this,"Test successfully added");
					tNormalValue.setText(null);
					tRate.setText(null);
					tTestName.setText(null);
					return;
				}
			/*	else
				{
					JOptionPane.showMessageDialog(this,"group not added","Message",JOptionPane.PLAIN_MESSAGE);
				}
				*/
			}
			catch(SQLException b)
			{
				b.printStackTrace();
			}
		}

		if(ae.getSource()==cancel)
		{
			this.dispose();
			new HomePage();
		}
	}
}

