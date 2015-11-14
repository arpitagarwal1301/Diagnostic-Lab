import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

class ModifyFields extends JFrame implements ActionListener
{
	JLabel lHead,lCreateNewID,lChangeDoc,lChangeDept,newUsername,newPassword,lnewDoctor,lnewDept;
	//JTextField tID,tPatientName;
	JButton changeDoc,changeDept,create,back;
	JTextField tnewDoctor,tnewDept,tnewUsername;
	JPasswordField tnewPassword;
	JPanel pNorth,pCenter,pSouth;
	JComboBox cChangeDoc,cChangeDept;
	Container content;
	String dept_name=null;
	String doc_name=null;
	int doc_id=0;
	int dept_id=0;
	public ModifyFields()
	{
		setSize((int)(Toolkit.getDefaultToolkit().getScreenSize().getWidth()),(int)(Toolkit.getDefaultToolkit().getScreenSize().getHeight())-40);
		setResizable(false);
		setTitle("MODIFY FIELDS");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//Creating Panels.
		pNorth=new JPanel(new FlowLayout(FlowLayout.CENTER));

		pCenter=new JPanel(new GridBagLayout());
		pCenter.setBackground(new Color(211,248,253));

		pSouth=new JPanel(new FlowLayout(FlowLayout.LEFT));
		pSouth.setBackground(new Color(211,248,253));

		//Creating Labels.
		lHead=new JLabel("MODIFY FIELDS");
		lHead.setForeground(Color.WHITE);
		Font f2=new Font("Papyrus",Font.BOLD,36);
		lHead.setFont(f2);

		Font f1=new Font("Goudy Old Style",Font.BOLD,16);

		lChangeDoc=new JLabel("Old name of Doctor");
		lChangeDoc.setFont(f1);

		lChangeDept=new JLabel("Old name of Department");
		lChangeDept.setFont(f1);
		lCreateNewID=new JLabel("**** CREATE NEW ACCOUNT ****");
		lCreateNewID.setFont(f1);
		lCreateNewID.setForeground(new Color(54,34,174));

		newUsername=new JLabel("New Username");
		newUsername.setFont(f1);
		newPassword=new JLabel("New Password");
		newPassword.setFont(f1);
		lnewDoctor=new JLabel("New Name of Doctor");
		lnewDoctor.setFont(f1);
		lnewDept=new JLabel("New name of Department");
		lnewDept.setFont(f1);

		//Creating Textfields.
		tnewUsername=new JTextField(14);
		tnewDoctor=new JTextField(14);
		tnewDept=new JTextField(14);

		//Creating Password Field.
		tnewPassword=new JPasswordField(14);

		//Creating Buttons.
		changeDoc=new JButton("Change");
		changeDoc.setFont(f1);
		changeDept=new JButton("Change");
		changeDept.setFont(f1);
		create=new JButton("Create");
		create.setFont(f1);
		//clear=new JButton("Clear");
		back=new JButton("BACK");
		back.setFont(f1);
		back.addActionListener(this);

		//Creating combo boxes.
		cChangeDoc=new JComboBox();
		cChangeDept=new JComboBox();

			//Adding Icon on top-left.
		ImageIcon img = new ImageIcon("pics/logo.jpg");
		this.setIconImage(img.getImage());

		content=getContentPane();

		//Adding lChangeDoc to pCenter.
		GridBagConstraints gc=new GridBagConstraints();
		gc.fill = GridBagConstraints.NONE;
		gc.gridx = 1;
		gc.gridwidth = 1;
		gc.gridy = 1;
		gc.ipadx = 0;
		gc.ipady = 0;
		gc.weightx = 0;
		gc.weighty = 0;
		gc.anchor = GridBagConstraints.CENTER;
		gc.insets=new Insets(0,0,20,20);
		pCenter.add(lChangeDoc,gc);

		//Adding cChangeDoc to pCenter.
		gc=new GridBagConstraints();
		cChangeDoc.addItem("Select Doctor");
		gc.fill = GridBagConstraints.NONE;
		gc.gridx = 2;
		gc.gridwidth = 1;
		gc.gridy = 1;
		gc.ipadx = 125;
		gc.ipady = 0;
		gc.weightx = 0;
		gc.weighty = 0;
		gc.anchor = GridBagConstraints.CENTER;
		gc.insets=new Insets(0,0,20,20);
		pCenter.add(cChangeDoc,gc);
		cChangeDoc.addActionListener(this);

		//Adding doctors to cChangeDoc ComboBox.
		try
		{
			Connection con=JDBCConnection.getConnection();
			PreparedStatement pstmt=con.prepareStatement("select doc_name from adddoctor");
			ResultSet rs=pstmt.executeQuery();
			while(rs.next())
			{
				cChangeDoc.addItem(rs.getString("doc_name"));
			}

		}
		catch(SQLException se)
		{
			se.printStackTrace();
		}

		//Adding lnewDoctor to pCenter.
		gc=new GridBagConstraints();
		gc.fill = GridBagConstraints.NONE;
		gc.gridx = 1;
		gc.gridwidth = 1;
		gc.gridy = 2;
		gc.ipadx = 0;
		gc.ipady = 0;
		gc.weightx = 0;
		gc.weighty = 0;
		gc.anchor = GridBagConstraints.CENTER;
		gc.insets=new Insets(0,0,20,20);
		pCenter.add(lnewDoctor,gc);


		//Adding tnewDoctor to pCenter.
		gc=new GridBagConstraints();
		gc.fill = GridBagConstraints.NONE;
		gc.gridx = 2;
		gc.gridwidth = 1;
		gc.gridy = 2;
		gc.ipadx = 0;
		gc.ipady = 0;
		gc.weightx = 0;
		gc.weighty = 0;
		gc.anchor = GridBagConstraints.CENTER;
		gc.insets=new Insets(0,0,20,20);
		pCenter.add(tnewDoctor,gc);

		//Adding change doctor button to pCenter.
		gc=new GridBagConstraints();
		gc.fill = GridBagConstraints.NONE;
		gc.gridx = 3;
		gc.gridwidth = 1;
		gc.gridy = 2;
		gc.ipadx = 0;
		gc.ipady = 0;
		gc.weightx = 0;
		gc.weighty = 0;
		gc.anchor = GridBagConstraints.CENTER;
		gc.insets=new Insets(0,0,20,20);
		pCenter.add(changeDoc,gc);
		changeDoc.addActionListener(this);


		//Adding lChangeDept to pCenter.
		gc=new GridBagConstraints();
		gc.fill = GridBagConstraints.NONE;
		gc.gridx = 1;
		gc.gridwidth = 1;
		gc.gridy = 3;
		gc.ipadx = 0;
		gc.ipady = 0;
		gc.weightx = 0;
		gc.weighty = 0;
		gc.anchor = GridBagConstraints.CENTER;
		gc.insets=new Insets(0,0,20,20);
		pCenter.add(lChangeDept,gc);


		//Adding cChangeDept to pCenter.
		gc=new GridBagConstraints();
		cChangeDept.addItem("Select Department");
		gc.fill = GridBagConstraints.NONE;
		gc.gridx = 2;
		gc.gridwidth = 1;
		gc.gridy = 3;
		gc.ipadx = 125;
		gc.ipady = 0;
		gc.weightx = 0;
		gc.weighty = 0;
		gc.anchor = GridBagConstraints.CENTER;
		gc.insets=new Insets(0,0,20,20);
		pCenter.add(cChangeDept,gc);


		try
		{
			Connection con=JDBCConnection.getConnection();
			PreparedStatement pstmt=con.prepareStatement("select dept_name from department");
			ResultSet rs=pstmt.executeQuery();
			while(rs.next())
			{
				cChangeDept.addItem(rs.getString("dept_name"));
			}

		}
		catch(SQLException se)
		{
			se.printStackTrace();
		}

		//Adding lnewDept to pCenter.
		gc=new GridBagConstraints();
		gc.fill = GridBagConstraints.NONE;
		gc.gridx = 1;
		gc.gridwidth = 1;
		gc.gridy = 4;
		gc.ipadx = 0;
		gc.ipady = 0;
		gc.weightx = 0;
		gc.weighty = 0;
		gc.anchor = GridBagConstraints.CENTER;
		gc.insets=new Insets(0,0,20,20);
		pCenter.add(lnewDept,gc);

		//Adding tnewDept to pCenter.
		gc=new GridBagConstraints();
		gc.fill = GridBagConstraints.NONE;
		gc.gridx = 2;
		gc.gridwidth = 1;
		gc.gridy = 4;
		gc.ipadx = 0;
		gc.ipady = 0;
		gc.weightx = 0;
		gc.weighty = 0;
		gc.anchor = GridBagConstraints.CENTER;
		gc.insets=new Insets(0,0,20,20);
		pCenter.add(tnewDept,gc);

		//Adding change department button to pCenter.
		gc=new GridBagConstraints();
		gc.fill = GridBagConstraints.NONE;
		gc.gridx = 3;
		gc.gridwidth = 1;
		gc.gridy = 4;
		gc.ipadx = 0;
		gc.ipady = 0;
		gc.weightx = 0;
		gc.weighty = 0;
		gc.anchor = GridBagConstraints.CENTER;
		gc.insets=new Insets(0,0,20,20);
		pCenter.add(changeDept,gc);
		changeDept.addActionListener(this);


		//Adding lCreateNewID to pCenter.
		gc=new GridBagConstraints();
		gc.fill = GridBagConstraints.NONE;
		gc.gridx = 1;
		gc.gridwidth = 1;
		gc.gridy = 5;
		gc.ipadx = 0;
		gc.ipady = 0;
		gc.weightx = 0;
		gc.weighty = 0;
		gc.anchor = GridBagConstraints.CENTER;
		gc.insets=new Insets(0,0,20,20);
		pCenter.add(lCreateNewID,gc);

		//Adding newUsername to pCenter.
		gc=new GridBagConstraints();
		gc.fill = GridBagConstraints.NONE;
		gc.gridx = 1;
		gc.gridwidth = 1;
		gc.gridy = 6;
		gc.ipadx = 0;
		gc.ipady = 0;
		gc.weightx = 0;
		gc.weighty = 0;
		gc.anchor = GridBagConstraints.CENTER;
		gc.insets=new Insets(0,0,20,20);
		pCenter.add(newUsername,gc);

		//Adding newPassword to pCenter.
		gc=new GridBagConstraints();
		gc.fill = GridBagConstraints.NONE;
		gc.gridx = 1;
		gc.gridwidth = 1;
		gc.gridy = 7;
		gc.ipadx = 0;
		gc.ipady = 0;
		gc.weightx = 0;
		gc.weighty = 0;
		gc.anchor = GridBagConstraints.CENTER;
		gc.insets=new Insets(0,0,20,20);
		pCenter.add(newPassword,gc);

		//Adding tnewUsername to pCenter.
		gc=new GridBagConstraints();
		gc.fill = GridBagConstraints.NONE;
		gc.gridx = 2;
		gc.gridwidth = 1;
		gc.gridy = 6;
		gc.ipadx = 0;
		gc.ipady = 0;
		gc.weightx = 0;
		gc.weighty = 0;
		gc.anchor = GridBagConstraints.CENTER;
		gc.insets=new Insets(0,0,20,20);
		pCenter.add(tnewUsername,gc);

		//Adding tnewPassword to pCenter.
		gc=new GridBagConstraints();
		gc.fill = GridBagConstraints.NONE;
		gc.gridx = 2;
		gc.gridwidth = 1;
		gc.gridy = 7;
		gc.ipadx = 0;
		gc.ipady = 0;
		gc.weightx = 0;
		gc.weighty = 0;
		gc.anchor = GridBagConstraints.CENTER;
		gc.insets=new Insets(0,0,20,20);
		pCenter.add(tnewPassword,gc);

		//Adding submit to pCenter.
		gc=new GridBagConstraints();
		gc.fill = GridBagConstraints.NONE;
		gc.gridx = 3;
		gc.gridwidth = 1;
		gc.gridy = 7;
		gc.ipadx = 0;
		gc.ipady = 0;
		gc.weightx = 0;
		gc.weighty = 0;
		gc.anchor = GridBagConstraints.CENTER;
		gc.insets=new Insets(0,0,20,20);
		pCenter.add(create,gc);
		create.addActionListener(this);

		/*//Adding clear to pCenter.
		gc=new GridBagConstraints();
		gc.fill = GridBagConstraints.NONE;
		gc.gridx = 2;
		gc.gridwidth = 1;
		gc.gridy = 8;
		gc.ipadx = 0;
		gc.ipady = 0;
		gc.weightx = 0;
		gc.weighty = 0;
		gc.anchor = GridBagConstraints.CENTER;
		gc.insets=new Insets(0,0,20,20);
		pCenter.add(clear,gc);*/

		pNorth.add(lHead);
		pNorth.setBackground(new Color(134,134,234));

		pSouth.add(back);

		content.add(pNorth,BorderLayout.NORTH);
		content.add(pCenter,BorderLayout.CENTER);
		content.add(pSouth,BorderLayout.SOUTH);

		setVisible(true);


	}

	public void actionPerformed(ActionEvent ae)
	{

		if(ae.getSource()==changeDoc)
		{
			if(String.valueOf(cChangeDoc.getSelectedItem()).equals("Select Doctor"))
			{
					JOptionPane.showMessageDialog(this,"Please Select Doctor","Warning",JOptionPane.WARNING_MESSAGE);
					tnewDoctor.setText(null);
					return;
			}
			if(tnewDoctor.getText().equals(""))
			{
					JOptionPane.showMessageDialog(this,"Enter new name for doctor . . !","Warning",JOptionPane.WARNING_MESSAGE);
					return;
			}

			try
			{
				doc_name=String.valueOf(cChangeDoc.getSelectedItem());
				Connection con =JDBCConnection.getConnection();
				String query="update adddoctor set doc_name=? where doc_name=?";
				PreparedStatement pstmt=con.prepareStatement(query);
				pstmt.setString(1,tnewDoctor.getText());
				pstmt.setString(2,doc_name);
				int a=pstmt.executeUpdate();
				if(a>0)
				{
						JOptionPane.showMessageDialog(this,"Doctor's Name changed successfully !");
						tnewDoctor.setText(null);
						cChangeDoc.setSelectedItem("Select Doctor");
						return;
				}
			}
			catch(SQLException qe)
			{
				qe.printStackTrace();

			}
		}

		if(ae.getSource()==changeDept)
		{
			if(String.valueOf(cChangeDept.getSelectedItem()).equals("Select Department"))
			{
					JOptionPane.showMessageDialog(this,"Please Select Department !","Warning",JOptionPane.WARNING_MESSAGE);
					tnewDept.setText(null);
					return;
			}
			if(tnewDept.getText().equals(""))
			{
					JOptionPane.showMessageDialog(this,"Enter new name for department !","Warning",JOptionPane.WARNING_MESSAGE);
					return;
			}

			try
			{
				dept_name=String.valueOf(cChangeDept.getSelectedItem());
				Connection con =JDBCConnection.getConnection();
				String query="update department set dept_name=? where dept_name=?";
				PreparedStatement pstmt=con.prepareStatement(query);
				pstmt.setString(1,tnewDept.getText());
				pstmt.setString(2,dept_name);
				int a=pstmt.executeUpdate();
				if(a>0)
				{
						JOptionPane.showMessageDialog(this,"Department's Name changed successfully !");
						tnewDept.setText(null);
						cChangeDept.setSelectedItem("Select Department");
						return;
				}
			}
			catch(SQLException qe)
			{
				qe.printStackTrace();

			}
		}


		if(ae.getSource()==create)
		{
			if(tnewUsername.getText().equals(""))
			{
					JOptionPane.showMessageDialog(this,"Please Enter Username !","Warning",JOptionPane.WARNING_MESSAGE);
					tnewUsername.setText(null);
					return;
			}
			if(tnewPassword.getText().equals(""))
			{
					JOptionPane.showMessageDialog(this,"Please Enter Password !","Warning",JOptionPane.WARNING_MESSAGE);
					return;
			}

			try
			{
			  	Connection con=JDBCConnection.getConnection();
					PreparedStatement pstmt=con.prepareStatement("select username from login");
					ResultSet rs=pstmt.executeQuery();
					while(rs.next())
					{
						if(tnewUsername.getText().equals(rs.getString("username")))
						{
							JOptionPane.showMessageDialog(this,"Username already exists!!","Warning",JOptionPane.WARNING_MESSAGE);
							tnewUsername.setText(null);
							return;
						}
					}
			}
			catch(SQLException qe)
			{
				qe.printStackTrace();

			}
			try
			{
			  	Connection con=JDBCConnection.getConnection();
					PreparedStatement pstmt=con.prepareStatement("select password from login");
					ResultSet rs=pstmt.executeQuery();
					while(rs.next())
					{
						if(tnewPassword.getText().equals(rs.getString("password")))
						{
							JOptionPane.showMessageDialog(this,"Password already exists!!","Warning",JOptionPane.WARNING_MESSAGE);
							tnewPassword.setText(null);
							return;
						}
					}
			}
			catch(SQLException qe)
			{
				qe.printStackTrace();

			}

			try
			{
				Connection con =JDBCConnection.getConnection();
				String query="insert into login values(?,?)";
				PreparedStatement pstmt=con.prepareStatement(query);
				pstmt.setString(1,tnewUsername.getText());
				pstmt.setString(2,tnewPassword.getText());
				int a=pstmt.executeUpdate();
				if(a>0)
				{
						JOptionPane.showMessageDialog(this,"New Account created successfully !");
						return;
				}
			}
			catch(SQLException qe)
			{
				qe.printStackTrace();

			}
		}
		if(ae.getSource()==back)
		{
			this.dispose();
			new HomePage();
		}

	}
	public static void main(String args[])
	{
		new ModifyFields();
	}

}