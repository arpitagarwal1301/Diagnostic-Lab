import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

class AddDepartment extends JFrame implements ActionListener
{
	JLabel departmentName,addDepartment;
	JButton ok,cancel;
	JTextField DeptName;
	JPanel pAddField,pDept,pWest;
	Container content;
	public AddDepartment()
	{
		setSize((int)(Toolkit.getDefaultToolkit().getScreenSize().getWidth()),(int)(Toolkit.getDefaultToolkit().getScreenSize().getHeight())-40);
		setResizable(false);
		setTitle("Add Department");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		departmentName=new JLabel("Department Name");
		Font f1=new Font("Goudy Old Style",Font.BOLD,16);
		departmentName.setFont(f1);
		addDepartment=new JLabel("ADD DEPARTMENT ",SwingConstants.CENTER);
		addDepartment.setForeground(Color.WHITE);
		Font f2=new Font("Papyrus",Font.BOLD,36);
		addDepartment.setFont(f2);

		ok=new JButton("ADD");
		ok.setFont(f1);
		cancel=new JButton("BACK");
		cancel.setFont(f1);

		DeptName=new JTextField();
		pDept=new JPanel(new FlowLayout(FlowLayout.CENTER,60,60));
		pDept.setBackground(new Color(134,134,234));
		pDept.add(addDepartment);
		pAddField=new JPanel(new GridBagLayout());
		pWest=new JPanel(new GridBagLayout());
		pWest.setBackground(new Color(211,248,253));
		
			//Adding Icon on top-left.
		ImageIcon img = new ImageIcon("pics/logo.jpg");
		this.setIconImage(img.getImage());


		//Adding image in West panel
		Icon i=new ImageIcon("pics/dept1.jpg");
		JLabel l1=new JLabel(i);
		GridBagConstraints gc=new GridBagConstraints();
		gc.fill = GridBagConstraints.NONE;
		gc.gridx = 2;
		gc.gridwidth = 1;
		gc.gridy = 1;
		gc.ipadx = 20;
		gc.ipady = 0;
		gc.weightx = 0;
		gc.weighty = 0;
		gc.anchor = GridBagConstraints.WEST;
		gc.insets=new Insets(0,0,20,0);
		pWest.add(l1,gc);


		content=getContentPane();
		//for label DepartmentNAme
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
		pAddField.add(departmentName,gc);

		//for text field Dept name
		gc=new GridBagConstraints();
		gc.fill = GridBagConstraints.NONE;
		gc.gridx = 2;
		gc.gridwidth = 2;
		gc.gridy = 1;
		gc.ipadx = 180;
		gc.ipady = 0;
		gc.weightx = 0;
		gc.weighty = 0;
		gc.anchor = GridBagConstraints.WEST;
		gc.insets=new Insets(0,0,20,0);
		pAddField.add(DeptName,gc);

			//for button OK
		gc=new GridBagConstraints();
		gc.fill = GridBagConstraints.NONE;
		gc.gridx = 2;
		gc.gridwidth = 1;
		gc.gridy = 2;
		gc.ipadx = 20;
		gc.ipady = 0;
		gc.weightx = 0;
		gc.weighty = 0;
		gc.anchor = GridBagConstraints.WEST;
		gc.insets=new Insets(0,0,20,20);
		pAddField.add(ok,gc);
		ok.addActionListener(this);

			//for button cancel
		gc=new GridBagConstraints();
		gc.fill = GridBagConstraints.NONE;
		gc.gridx = 3;
		gc.gridwidth = 1;
		gc.gridy = 2;
		gc.ipadx = 10;
		gc.ipady = 0;
		gc.weightx = 0;
		gc.weighty = 0;
		gc.anchor = GridBagConstraints.WEST;
		gc.insets=new Insets(0,0,20,0);
		pAddField.add(cancel,gc);
		cancel.addActionListener(this);

		pAddField.setBackground(new Color(211,248,253));

		content.add(pDept,BorderLayout.NORTH);
		content.add(pAddField,BorderLayout.CENTER);
		content.add(pWest,BorderLayout.WEST);

		setVisible(true);
	}

	public void actionPerformed(ActionEvent ae)
	{
		boolean flag=false;
		Connection con=null;
		if(ae.getSource()==ok)
		{
			if(DeptName.getText().equals(""))
			{

				JOptionPane.showMessageDialog(this,"Department name Field can not be blank !!","Warning",JOptionPane.WARNING_MESSAGE);
				return;
			}
			else
			{
				try
				{
					con=JDBCConnection.getConnection();
					PreparedStatement pstmt1=con.prepareStatement("select dept_name from department");
					ResultSet rs=pstmt1.executeQuery();
					while(rs.next())
					{
						if(DeptName.getText().equals(rs.getString("dept_name")))
						{

							JOptionPane.showMessageDialog(this,"Entered Department Name already exists..!!","Warning",JOptionPane.WARNING_MESSAGE);
							flag=true;
							DeptName.setText("");
							return;
						}

					}
					if(!false)
					{
						try
						{
							con=JDBCConnection.getConnection();
							PreparedStatement pstmt=con.prepareStatement("insert into department values(dept_id.nextval,?)");
							pstmt.setString(1,DeptName.getText());
							int a=pstmt.executeUpdate();
							if(a>0)
							{
								JOptionPane.showMessageDialog(this,"Department successfully inserted");
								DeptName.setText(null);
							}
						}
						catch(SQLException e)
						{
							e.printStackTrace();
						}
					}
				}
				catch(SQLException e)
				{
					e.printStackTrace();
				}
			}
		}

		if(ae.getSource()==cancel)
		{
			this.dispose();
			new HomePage();
		}

	}



}