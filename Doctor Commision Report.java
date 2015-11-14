import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

class DoctorCommisionReport extends JFrame implements ActionListener
{
	JLabel LabCenter,docReport,docId,docName,commPer,totalCom,prev,commAmt;
	JLabel dId,dName,dComm,dCamt;
	JButton click;
	JPanel pNorth,pCenter,pSouth,pEast;
	Container content;
	String d_name=null;
	int d_Id=0;
	int d_Comm=0;
	int i;
	int r=0;
	int camt=0;

	public DoctorCommisionReport()
	{
		setSize((int)(Toolkit.getDefaultToolkit().getScreenSize().getWidth()),(int)(Toolkit.getDefaultToolkit().getScreenSize().getHeight())-40);
		setTitle("Doctor Commission Report");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		LabCenter=new JLabel("Medi-Scan Diagnostic Lab",SwingConstants.CENTER);
		docReport=new JLabel("Doctor Commision Report",SwingConstants.CENTER);

		LabCenter.setForeground(Color.WHITE);
		Font f2=new Font("Papyrus",Font.BOLD,36);
		LabCenter.setFont(f2);

		docReport.setForeground(Color.WHITE);
		Font f3=new Font("Papyrus",Font.BOLD,32);
		docReport.setFont(f3);

		//Adding image.
		Icon i1=new ImageIcon("pics/dept2.jpg");
		JLabel l1=new JLabel(i1);

		commPer=new JLabel("Commision Per");
		Font f1=new Font("Goudy Old Style",Font.BOLD,16);
		commPer.setFont(f1);
		commPer.setForeground(new Color(54,34,174));

		docId=new JLabel("Doctor ID");
		docId.setFont(f1);
		docId.setForeground(new Color(54,34,174));

		docName=new JLabel("Doctor Name");
		docName.setFont(f1);
		docName.setForeground(new Color(54,34,174));


		totalCom=new JLabel("Commision Percentage(%)");
		totalCom.setFont(f1);
		totalCom.setForeground(new Color(54,34,174));

		commAmt=new JLabel("Comission Amount");
		commAmt.setFont(f1);
		commAmt.setForeground(new Color(54,34,174));

		prev=new JLabel("Click here for Previous Menu");
		prev.setFont(f1);

		click=new JButton("Click");
		click.setFont(f1);

		click.addActionListener(this);

		pNorth=new JPanel(new GridLayout(2,1));
		pNorth.setBackground(new Color(134,134,234));

		pCenter=new JPanel(new GridBagLayout());
		pCenter.setBackground(new Color(211,248,253));

		pSouth=new JPanel(new FlowLayout(FlowLayout.CENTER));
		pSouth.setBackground(new Color(211,248,253));

		pEast=new JPanel(new FlowLayout(FlowLayout.CENTER));
		pEast.setBackground(new Color(211,248,253));
		pEast.add(l1);

		//Adding Icon on top-left.
		ImageIcon img = new ImageIcon("pics/logo.jpg");
		this.setIconImage(img.getImage());

		content=getContentPane();

		GridBagConstraints gc=new GridBagConstraints();

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
		pCenter.add(docId,gc);

		//for label doctorName
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
		pCenter.add(docName,gc);

			//for label doctorName
		gc=new GridBagConstraints();
		gc.fill = GridBagConstraints.NONE;
		gc.gridx = 3;
		gc.gridwidth = 1;
		gc.gridy = 1;
		gc.ipadx = 0;
		gc.ipady = 10;
		gc.weightx = 0;
		gc.weighty = 0;
		gc.anchor = GridBagConstraints.WEST;
		gc.insets=new Insets(0,0,20,20);
		pCenter.add(commPer,gc);

			//for label doctorName
		gc=new GridBagConstraints();
		gc.fill = GridBagConstraints.NONE;
		gc.gridx = 4;
		gc.gridwidth = 1;
		gc.gridy = 1;
		gc.ipadx = 0;
		gc.ipady = 10;
		gc.weightx = 0;
		gc.weighty = 0;
		gc.anchor = GridBagConstraints.WEST;
		gc.insets=new Insets(0,0,20,20);
		pCenter.add(commAmt,gc);


		try
		{
			Connection con=JDBCConnection.getConnection();
			PreparedStatement pstmt=con.prepareStatement("select * from adddoctor");
			ResultSet rs=pstmt.executeQuery();
			i=1;
			while(rs.next())
			{


					gc=new GridBagConstraints();
					gc.fill = GridBagConstraints.NONE;
					gc.gridx = 1;
					gc.gridwidth = 1;
					gc.gridy = i+1;
					gc.ipadx = 0;
					gc.ipady = 10;
					gc.weightx = 0;
					gc.weighty = 0;
					gc.anchor = GridBagConstraints.WEST;
					gc.insets=new Insets(0,0,20,20);
					d_Id=rs.getInt("doc_id");
					dId=new JLabel(d_Id+"");
					pCenter.add(dId,gc);


					gc=new GridBagConstraints();
					gc.fill = GridBagConstraints.NONE;
					gc.gridx = 2;
					gc.gridwidth = 1;
					gc.gridy = i+1;
					gc.ipadx = 0;
					gc.ipady = 10;
					gc.weightx = 0;
					gc.weighty = 0;
					gc.anchor = GridBagConstraints.WEST;
					gc.insets=new Insets(0,0,20,20);
					d_name=rs.getString("doc_name");
					dName=new JLabel(d_name);
					pCenter.add(dName,gc);

						gc=new GridBagConstraints();
					gc.fill = GridBagConstraints.NONE;
					gc.gridx = 3;
					gc.gridwidth = 1;
					gc.gridy = i+1;
					gc.ipadx = 0;
					gc.ipady = 10;
					gc.weightx = 0;
					gc.weighty = 0;
					gc.anchor = GridBagConstraints.WEST;
					gc.insets=new Insets(0,0,20,20);
					d_Comm=rs.getInt("com_per");
					dComm=new JLabel(d_Comm+"");
					pCenter.add(dComm,gc);

						gc=new GridBagConstraints();
					gc.fill = GridBagConstraints.NONE;
					gc.gridx = 4;
					gc.gridwidth = 1;
					gc.gridy = i+1;
					gc.ipadx = 0;
					gc.ipady = 10;
					gc.weightx = 0;
					gc.weighty = 0;
					gc.anchor = GridBagConstraints.WEST;
					gc.insets=new Insets(0,0,20,20);
					camt=rs.getInt("com_amt");
					dCamt=new JLabel(camt+"");
					pCenter.add(dCamt,gc);

				i++;

			}
		}
		catch(SQLException s)
		{
			s.printStackTrace();
		}



		pNorth.add(LabCenter);
		pNorth.add(docReport);



		pSouth.add(prev);
		pSouth.add(click);



		content.add(pNorth,BorderLayout.NORTH);
		content.add(pCenter,BorderLayout.CENTER);
		content.add(pSouth,BorderLayout.SOUTH);
		content.add(pEast,BorderLayout.EAST);

		setVisible(true);

	}
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==click)
		{
			this.dispose();
			new HomePage();
		}
	}

}