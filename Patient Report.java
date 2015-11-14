import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

class PatientReport extends JFrame implements ActionListener
{
	JLabel lpatient_id,lpatient_name,addPatient;
	JTextField tpatientName;
	JComboBox cPatientId;
	Container content;
	JButton ok,cancel;
	JPanel pPatient,pCenter;
	String first_name=null;
	int patient_id=0;
	public PatientReport()
	{
		setSize((int)(Toolkit.getDefaultToolkit().getScreenSize().getWidth()),(int)(Toolkit.getDefaultToolkit().getScreenSize().getHeight())-40);
		setResizable(false);
		setTitle("Patient Report");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Font f1=new Font("Goudy Old Style",Font.BOLD,16);
		addPatient=new JLabel("Patient Id");
		addPatient.setFont(f1);

		lpatient_id=new JLabel("Patient ID");
		lpatient_id.setFont(f1);

		lpatient_name=new JLabel("Patient name");
		lpatient_name.setFont(f1);


		tpatientName=new JTextField(10);
		cPatientId=new JComboBox();

		ok=new JButton("SUBMIT");
		ok.setFont(f1);

		cancel=new JButton("BACK");
		cancel.setFont(f1);


		pPatient=new JPanel(new FlowLayout(FlowLayout.CENTER));
		pPatient.setBackground(new Color(143,249,221));
		pCenter=new JPanel(new GridBagLayout());
		pCenter.setBackground(new Color(211,248,253));

			//Adding Icon on top-left.
		ImageIcon img = new ImageIcon("pics/logo.jpg");
		this.setIconImage(img.getImage());

		//Adding image.
		Icon i1=new ImageIcon("pics/LoginPic.jpg");
		JLabel l1=new JLabel(i1);

			content=getContentPane();
		//for label Patient_id
		GridBagConstraints gc=new GridBagConstraints();
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
		pCenter.add(lpatient_id,gc);

		//for combo box cPatientId
		gc=new GridBagConstraints();
		gc.fill = GridBagConstraints.NONE;
		gc.gridx = 2;
		gc.gridwidth = 2;
		gc.gridy = 1;
		gc.ipadx = 60;
		gc.ipady = 0;
		gc.weightx = 0;
		gc.weighty = 0;
		gc.anchor = GridBagConstraints.WEST;
		gc.insets=new Insets(0,0,20,0);
		pCenter.add(cPatientId,gc);
		cPatientId.addActionListener(this);
			try
		{
			Connection con=JDBCConnection.getConnection();
			PreparedStatement pstmt=con.prepareStatement("select patient_id from patientreg");
			ResultSet rs=pstmt.executeQuery();
			while(rs.next())
			{
				cPatientId.addItem(rs.getString("patient_id"));
			}

		}
		catch(SQLException se)
		{
			se.printStackTrace();
		}

			//for label patient_name
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
		gc.insets=new Insets(0,0,20,20);
		pCenter.add(lpatient_name,gc);


			//for Text Field tpatientName
		gc=new GridBagConstraints();
		gc.fill = GridBagConstraints.NONE;
		gc.gridx = 2;
		gc.gridwidth = 1;
		gc.gridy = 2;
		gc.ipadx = 0;
		gc.ipady = 0;
		gc.weightx = 0;
		gc.weighty = 0;
		gc.anchor = GridBagConstraints.WEST;
		gc.insets=new Insets(0,0,20,0);
		pCenter.add(tpatientName,gc);

				//for button OK
		gc=new GridBagConstraints();
		gc.fill = GridBagConstraints.NONE;
		gc.gridx = 1;
		gc.gridwidth = 1;
		gc.gridy = 3;
		gc.ipadx = 30;
		gc.ipady = 0;
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
		gc.ipadx = 30;
		gc.ipady = 0;
		gc.weightx = 0;
		gc.weighty = 0;
		gc.anchor = GridBagConstraints.WEST;
		gc.insets=new Insets(0,0,20,0);
		pCenter.add(cancel,gc);
		cancel.addActionListener(this);

		pPatient.add(l1);

		content.add(pPatient,BorderLayout.NORTH);
		content.add(pCenter,BorderLayout.CENTER);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==cPatientId)
		{
			patient_id=Integer.parseInt(String.valueOf(cPatientId.getSelectedItem()));
			try
			{

				Connection con=JDBCConnection.getConnection();
				PreparedStatement pstmt=con.prepareStatement("select first_name from patientreg where patient_id=?");
				pstmt.setInt(1,patient_id);
				ResultSet rs=pstmt.executeQuery();
				if(rs.next())
				{
					first_name=rs.getString("first_name");
					tpatientName.setText(first_name);

					/*s.name.setText(first_name);
					sex=rs.getString("sex");
					s.psex.setText(sex);
					age=rs.getInt("age");
					s.pAge.setText(age);
					testname1=rs.getString("test_name");
					s.testname.setText(testname1)*/
				}
			}
			catch(SQLException s)
			{
				s.printStackTrace();
			}

		}

		if(ae.getSource()==ok)
		{
			this.dispose();

			new Summary(Integer.parseInt(String.valueOf(cPatientId.getSelectedItem())));
		}
		if(ae.getSource()==cancel)
		{
			this.dispose();
			new HomePage();
		}
	}

}