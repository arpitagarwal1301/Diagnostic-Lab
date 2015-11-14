import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

class Summary extends JFrame implements ActionListener
{
	JLabel head,res,hello,fin,pname,ldate,age,sex,tname,nvalue,trate,tresult,tamt,name,name1,date1,pAge,psex,testname,normal_value1,rate1,result,rate2;
	JButton exit;
	JPanel pHead,pCenter,pCom,pSouth;
	String first_name=null;
	String p_sex=null;
	String  te_name=null;
	String te_res=null;
	String lname=null;
	String t_date=null;
	int p_age=0;
	int te_rate=0;
	int n_value=0;
	int t_id=0;
	Container content;
	int patient_id;


public Summary(int patient_id)
{
		this.patient_id=patient_id;
		setTitle("Summary");
		setSize((int)(Toolkit.getDefaultToolkit().getScreenSize().getWidth()),(int)(Toolkit.getDefaultToolkit().getScreenSize().getHeight())-40);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		head=new JLabel("MEDI_SCAN DIAGNOSTIC LAB SERVICES",SwingConstants.CENTER);
		head.setForeground(Color.WHITE);
		Font f2=new Font("Papyrus",Font.BOLD,36);
		head.setFont(f2);
		res=new JLabel("RESULT SUMMARY",SwingConstants.CENTER);
		res.setForeground(Color.WHITE);
		Font f3=new Font("Papyrus",Font.BOLD,28);
		res.setFont(f3);
		Font f1=new Font("Goudy Old Style",Font.BOLD,16);
		hello=new JLabel("Hello Mr./Miss ");
		hello.setForeground(new Color(54,34,174));
		hello.setFont(f1);

		fin=new JLabel("Your Medical Test Is Finished");
		fin.setFont(f1);
		fin.setForeground(new Color(54,34,174));
		pname=new JLabel("Patient Name");
		pname.setForeground(new Color(54,34,174));
		pname.setFont(f1);
		ldate=new JLabel("Test Date");
		ldate.setForeground(new Color(54,34,174));
		ldate.setFont(f1);
		age=new JLabel("Age");
		age.setForeground(new Color(54,34,174));
		age.setFont(f1);
		sex=new JLabel("Sex");
		sex.setForeground(new Color(54,34,174));
		sex.setFont(f1);
		tname=new JLabel("Test Name");
		tname.setForeground(new Color(54,34,174));
		tname.setFont(f1);
		nvalue=new JLabel("Normal Value");
		nvalue.setForeground(new Color(54,34,174));
		nvalue.setFont(f1);
		trate=new JLabel("Test Rate");
		trate.setForeground(new Color(54,34,174));
		trate.setFont(f1);
		tresult=new JLabel("Test Result");
		tresult.setForeground(new Color(54,34,174));
		tresult.setFont(f1);
		tamt=new JLabel("Total Amout");
		tamt.setForeground(new Color(54,34,174));
		tamt.setFont(f1);



		exit=new JButton("EXIT");
		exit.setFont(f1);


		pHead=new JPanel(new GridLayout(2,1));
		pHead.setBackground(new Color(134,134,234));
		pCenter=new JPanel(new GridBagLayout());
		pCenter.setBackground(new Color(211,248,253));
		pCom=new JPanel(new BorderLayout());
		pCom.setBackground(new Color(211,248,253));
		pSouth=new JPanel(new FlowLayout(FlowLayout.RIGHT));
		pSouth.setBackground(new Color(211,248,253));

			//Adding Icon on top-left.
		ImageIcon img = new ImageIcon("pics/logo.jpg");
		this.setIconImage(img.getImage());

			try
		{
			Connection con=JDBCConnection.getConnection();
			PreparedStatement pstmt=con.prepareStatement("Select first_name,last_name,age,sex,test_id,tdate from patientreg where patient_id=?");
			pstmt.setInt(1,this.patient_id);
			ResultSet rs=pstmt.executeQuery();
				if(rs.next())
				{
					first_name=rs.getString("first_name");
					lname=rs.getString("last_name");
					name= new JLabel(first_name+" "+lname);
					name1=new JLabel(first_name+" "+lname);
					p_age=rs.getInt("age");
					pAge=new JLabel(p_age+"");
					p_sex=rs.getString("sex");
					psex=new JLabel(p_sex);
					t_id=rs.getInt("test_id");
					t_date=rs.getString("tdate");
					date1=new JLabel(t_date);
					}
			}
			catch(SQLException s)
			{
				s.printStackTrace();
			}

		try
		{
			Connection con=JDBCConnection.getConnection();
			PreparedStatement pstmt=con.prepareStatement("Select test_result from reportbydoctor where patient_id=?");
			pstmt.setInt(1,this.patient_id);
			ResultSet rs=pstmt.executeQuery();
				if(rs.next())
				{

					te_res=rs.getString("test_result");
					result=new JLabel(te_res);

				}
		}
			catch(SQLException s)
			{
				s.printStackTrace();
			}

					try
		{
			Connection con=JDBCConnection.getConnection();
			PreparedStatement pstmt=con.prepareStatement("select normal_val,rate,test_name from addtest where test_id=?");
			pstmt.setInt(1,t_id);
			ResultSet rs=pstmt.executeQuery();
			if(rs.next())
			{
				n_value=rs.getInt("normal_val");
				normal_value1=new JLabel(n_value+"");
				te_rate=rs.getInt("rate");
				rate1=new JLabel(te_rate+"");
				rate2=new JLabel(te_rate+"");
				te_name=rs.getString("test_name");
				testname=new JLabel(te_name);
			}
		}
		catch(SQLException a)
		{
			a.printStackTrace();
		}

		content=getContentPane();

		//for label hello
		GridBagConstraints gc=new GridBagConstraints();
		gc.fill = GridBagConstraints.NONE;
		gc.gridx = 1;
		gc.gridwidth = 1;
		gc.gridy = 1;
		gc.ipadx = 0;
		gc.ipady = 10;
		gc.weightx = 0;
		gc.weighty = 0;
		gc.anchor = GridBagConstraints.WEST;
		gc.insets=new Insets(0,50,20,0);
		pCenter.add(hello,gc);

		//for label name1
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
		gc.insets=new Insets(0,0,20,0);
		pCenter.add(name1,gc);

		//for label fin
		 gc=new GridBagConstraints();
		gc.fill = GridBagConstraints.NONE;
		gc.gridx = 3;
		gc.gridwidth = 2;
		gc.gridy = 1;
		gc.ipadx = 0;
		gc.ipady = 10;
		gc.weightx = 0;
		gc.weighty = 0;
		gc.anchor = GridBagConstraints.WEST;
		gc.insets=new Insets(0,0,20,20);
		pCenter.add(fin,gc);

		//for label pname
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
		pCenter.add(pname,gc);

		//for label name
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
		pCenter.add(name,gc);

			//for label ldate
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
		pCenter.add(ldate,gc);

		//for label date1
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
		pCenter.add(date1,gc);

		//for label age
		gc=new GridBagConstraints();
		gc.fill = GridBagConstraints.NONE;
		gc.gridx = 1;
		gc.gridwidth = 1;
		gc.gridy = 4;
		gc.ipadx = 0;
		gc.ipady = 10;
		gc.weightx = 0;
		gc.weighty = 0;
		gc.anchor = GridBagConstraints.WEST;
		gc.insets=new Insets(0,0,20,20);
		pCenter.add(age,gc);

			//for label pAge
		gc=new GridBagConstraints();
		gc.fill = GridBagConstraints.NONE;
		gc.gridx = 2;
		gc.gridwidth = 1;
		gc.gridy = 4;
		gc.ipadx = 0;
		gc.ipady = 10;
		gc.weightx = 0;
		gc.weighty = 0;
		gc.anchor = GridBagConstraints.WEST;
		gc.insets=new Insets(0,0,20,20);
		pCenter.add(pAge,gc);

		//for label sex
		gc=new GridBagConstraints();
		gc.fill = GridBagConstraints.NONE;
		gc.gridx = 1;
		gc.gridwidth = 1;
		gc.gridy =5;
		gc.ipadx = 125;
		gc.ipady = 10;
		gc.weightx = 0;
		gc.weighty = 0;
		gc.anchor = GridBagConstraints.WEST;
		gc.insets=new Insets(0,0,20,20);
		pCenter.add(sex,gc);

			//for label psex
		gc=new GridBagConstraints();
		gc.fill = GridBagConstraints.NONE;
		gc.gridx = 2;
		gc.gridwidth = 1;
		gc.gridy = 5;
		gc.ipadx = 0;
		gc.ipady = 10;
		gc.weightx = 0;
		gc.weighty = 0;
		gc.anchor = GridBagConstraints.WEST;
		gc.insets=new Insets(0,0,20,20);

		pCenter.add(psex,gc);

		//for label tname
		gc=new GridBagConstraints();
		gc.fill = GridBagConstraints.NONE;
		gc.gridx = 1;
		gc.gridwidth = 1;
		gc.gridy = 6;
		gc.ipadx = 0;
		gc.ipady = 10;
		gc.weightx = 0;
		gc.weighty = 0;
		gc.anchor = GridBagConstraints.WEST;
		gc.insets=new Insets(0,0,20,20);
		pCenter.add(tname,gc);




			//for label nvalue
		gc=new GridBagConstraints();
		gc.fill = GridBagConstraints.NONE;
		gc.gridx = 2;
		gc.gridwidth = 1;
		gc.gridy = 6;
		gc.ipadx = 0;
		gc.ipady = 10;
		gc.weightx = 0;
		gc.weighty = 0;
		gc.anchor = GridBagConstraints.WEST;
		gc.insets=new Insets(0,0,20,20);
		pCenter.add(nvalue,gc);

			//for label trate
		gc=new GridBagConstraints();
		gc.fill = GridBagConstraints.NONE;
		gc.gridx = 3;
		gc.gridwidth = 1;
		gc.gridy = 6;
		gc.ipadx = 0;
		gc.ipady = 10;
		gc.weightx = 0;
		gc.weighty = 0;
		gc.anchor = GridBagConstraints.WEST;
		gc.insets=new Insets(0,0,20,20);
		pCenter.add(trate,gc);

			//for label tresult
		gc=new GridBagConstraints();
		gc.fill = GridBagConstraints.NONE;
		gc.gridx = 4;
		gc.gridwidth = 1;
		gc.gridy = 6;
		gc.ipadx = 0;
		gc.ipady = 10;
		gc.weightx = 0;
		gc.weighty = 0;
		gc.anchor = GridBagConstraints.WEST;
		gc.insets=new Insets(0,0,20,20);
		pCenter.add(tresult,gc);

				//for label testname
		gc=new GridBagConstraints();
		gc.fill = GridBagConstraints.NONE;
		gc.gridx = 1;
		gc.gridwidth = 1;
		gc.gridy = 7;
		gc.ipadx = 0;
		gc.ipady = 10;
		gc.weightx = 0;
		gc.weighty = 0;
		gc.anchor = GridBagConstraints.WEST;
		gc.insets=new Insets(0,0,20,20);
		pCenter.add(testname,gc);


			//for label normal_value1
		gc=new GridBagConstraints();
		gc.fill = GridBagConstraints.NONE;
		gc.gridx = 2;
		gc.gridwidth = 1;
		gc.gridy = 7;
		gc.ipadx = 0;
		gc.ipady = 10;
		gc.weightx = 0;
		gc.weighty = 0;
		gc.anchor = GridBagConstraints.WEST;
		gc.insets=new Insets(0,0,20,20);
		pCenter.add(normal_value1,gc);

			// for label rate1
		gc=new GridBagConstraints();
		gc.fill = GridBagConstraints.NONE;
		gc.gridx = 3;
		gc.gridwidth = 1;
		gc.gridy = 7;
		gc.ipadx = 0;
		gc.ipady = 10;
		gc.weightx = 0;
		gc.weighty = 0;
		gc.anchor = GridBagConstraints.WEST;
		gc.insets=new Insets(0,0,20,20);
		pCenter.add(rate1,gc);

			//for label result
		gc=new GridBagConstraints();
		gc.fill = GridBagConstraints.NONE;
		gc.gridx = 4;
		gc.gridwidth = 1;
		gc.gridy = 7;
		gc.ipadx = 0;
		gc.ipady = 10;
		gc.weightx = 0;
		gc.weighty = 0;
		gc.anchor = GridBagConstraints.WEST;
		gc.insets=new Insets(0,0,20,20);
		pCenter.add(result,gc);

			//for label tamt
		gc=new GridBagConstraints();
		gc.fill = GridBagConstraints.NONE;
		gc.gridx =3;
		gc.gridwidth = 1;
		gc.gridy = 8;
		gc.ipadx = 0;
		gc.ipady = 10;
		gc.weightx = 0;
		gc.weighty = 0;
		gc.anchor = GridBagConstraints.WEST;
		gc.insets=new Insets(0,0,20,20);
		pCenter.add(tamt,gc);


			//for label rate2
		gc=new GridBagConstraints();
		gc.fill = GridBagConstraints.NONE;
		gc.gridx =4;
		gc.gridwidth = 1;
		gc.gridy = 8;
		gc.ipadx = 0;
		gc.ipady = 10;
		gc.weightx = 0;
		gc.weighty = 0;
		gc.anchor = GridBagConstraints.WEST;
		gc.insets=new Insets(0,0,20,20);
		pCenter.add(rate2,gc);



		exit.addActionListener(this);
		pSouth.add(exit);
		content.add(pSouth,BorderLayout.SOUTH);


		pHead.add(head);
		pHead.add(res);

		content.add(pHead,BorderLayout.NORTH);
		content.add(pCenter,BorderLayout.CENTER);
		setVisible(true);



}

	public  void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==exit)
		{
			this.dispose();
			new HomePage();
		}
	}
}