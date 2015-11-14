import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

class AddDoctor extends JFrame implements ActionListener
{
	JLabel addDoctor,doctorName,comm;
	JButton ok,cancel;
	JTextField tDocName,tComm;
	JPanel pNorth,pCenter,pEast;
	Container content;
	boolean flag;
	int t_id=0;
	int t_rate=0;
	int c_amt=0;

	public AddDoctor()
	{
		setSize((int)(Toolkit.getDefaultToolkit().getScreenSize().getWidth()),(int)(Toolkit.getDefaultToolkit().getScreenSize().getHeight())-40);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		addDoctor=new JLabel("ADD DOCTOR");
    	addDoctor.setForeground(Color.WHITE);
    	Font f1=new Font("Papyrus",Font.BOLD,36);
    	addDoctor.setFont(f1);
		doctorName=new JLabel("Doctor Name");
    	Font f2=new Font("Goudy Old Style",Font.BOLD,16);
    	doctorName.setFont(f2);
		comm=new JLabel("Comm.per(%)");
    	comm.setFont(f2);

		tDocName=new JTextField(14);
		tComm=new JTextField(14);

		ok=new JButton("OK");
    	ok.setFont(f2);

		cancel=new JButton("BACK");
    	cancel.setFont(f2);

		pNorth=new JPanel(new FlowLayout(FlowLayout.CENTER,70,70));
    	pNorth.setBackground(new Color(134,134,234));
		pCenter=new JPanel(new GridBagLayout());
    	pCenter.setBackground(new Color(211,248,253));
		pEast=new JPanel(new FlowLayout());
    	pEast.setBackground(new Color(211,248,253));
    	//Adding Icon on top-left.
		ImageIcon img = new ImageIcon("pics/logo.jpg");
		this.setIconImage(img.getImage());


		content=getContentPane();

    //Adding image in East panel
    Icon i=new ImageIcon("pics/scope.jpg");
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
    pEast.add(l1,gc);

		//for label doctorName
	  gc=new GridBagConstraints();
		gc.fill = GridBagConstraints.NONE;
		gc.gridx = 1;
		gc.gridwidth = 1;
		gc.gridy = 1;
		gc.ipadx = 0;
		gc.ipady = 10;
		gc.weightx = 0;
		gc.weighty = 0;
		gc.anchor = GridBagConstraints.WEST;
		gc.insets=new Insets(0,0,20,20);
		pCenter.add(doctorName,gc);

		//for TextField tDocName
		gc=new GridBagConstraints();
		gc.fill = GridBagConstraints.NONE;
		gc.gridx = 2;
		gc.gridwidth = 1;
		gc.gridy = 1;
		gc.ipadx = 0;
		gc.ipady = 10;
		gc.weightx = 0;
		gc.weighty = 0;
		gc.anchor = GridBagConstraints.WEST;
		gc.insets=new Insets(0,0,20,20);
		pCenter.add(tDocName,gc);

		//for label comm
		gc=new GridBagConstraints();
		gc.fill = GridBagConstraints.NONE;
		gc.gridx = 1;
		gc.gridwidth = 1;
		gc.gridy = 2;
		gc.ipadx = 0;
		gc.ipady = 10;
		gc.weightx = 0;
		gc.weighty = 0;
		gc.anchor = GridBagConstraints.WEST;
		gc.insets=new Insets(0,0,20,20);
		pCenter.add(comm,gc);

		//for tetField Comm
		gc=new GridBagConstraints();
		gc.fill = GridBagConstraints.NONE;
		gc.gridx = 2;
		gc.gridwidth = 1;
		gc.gridy = 2;
		gc.ipadx = 0;
		gc.ipady = 10;
		gc.weightx = 0;
		gc.weighty = 0;
		gc.anchor = GridBagConstraints.WEST;
		gc.insets=new Insets(0,0,20,20);
		pCenter.add(tComm,gc);

	//for button ok
		gc=new GridBagConstraints();
		gc.fill = GridBagConstraints.NONE;
		gc.gridx = 1;
		gc.gridwidth = 1;
		gc.gridy = 3;
		gc.ipadx = 0;
		gc.ipady = 10;
		gc.weightx = 0;
		gc.weighty = 0;
		gc.anchor = GridBagConstraints.WEST;
		gc.insets=new Insets(0,0,20,20);
		pCenter.add(ok,gc);
		ok.addActionListener(this);


				//for button cancel
		gc=new GridBagConstraints();
		gc.fill = GridBagConstraints.NONE;
		gc.gridx = 2;
		gc.gridwidth = 1;
		gc.gridy = 3;
		gc.ipadx = 0;
		gc.ipady = 10;
		gc.weightx = 0;
		gc.weighty = 0;
		gc.anchor = GridBagConstraints.WEST;
		gc.insets=new Insets(0,0,20,20);
		pCenter.add(cancel,gc);
		cancel.addActionListener(this);

		pNorth.add(addDoctor);

		content.add(pNorth,BorderLayout.NORTH);
		content.add(pCenter,BorderLayout.CENTER);
		content.add(pEast,BorderLayout.EAST);

		setVisible(true);

	}

	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==ok)
		{
			if(tDocName.getText().equals(""))
			{
				JOptionPane.showMessageDialog(this,"Please enter the Doctor Name..!!","Warning",JOptionPane.WARNING_MESSAGE);
				return;
			}

			else if(tComm.getText().equals(""))
			{
				JOptionPane.showMessageDialog(this,"Please Enter the Percentage Commision!","Warning",JOptionPane.WARNING_MESSAGE);
				return;
			}

			else
			{
				try
				{
					Connection con=JDBCConnection.getConnection();
					PreparedStatement pstmt1=con.prepareStatement("select doc_name from adddoctor");
					ResultSet rs=pstmt1.executeQuery();
					while(rs.next())
					{
						if(tDocName.getText().equals(rs.getString("doc_name")))
						{

							JOptionPane.showMessageDialog(this,"Entered Doctor Name already exists..!!","Warning",JOptionPane.WARNING_MESSAGE);
							flag=true;
							tDocName.setText("");
							tComm.setText("");
							return;
						}

					}
					if(!false)
					{
						try
						{
							con=JDBCConnection.getConnection();
							PreparedStatement pstmt=con.prepareStatement("insert into adddoctor values(doc_id.nextval,?,?,?)");
							pstmt.setString(1,tDocName.getText());
							pstmt.setString(2,tComm.getText());
							pstmt.setInt(3,c_amt);

							int a=pstmt.executeUpdate();
							if(a>0)
							{
								JOptionPane.showMessageDialog(this,"Doctor successfully added");
								tDocName.setText(null);
								tComm.setText(null);
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