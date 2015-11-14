import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class HomePage extends JFrame implements ActionListener
{
	JLabel lName,lPhone,lTag,lAdmin,lPic;
	JButton PatientReport,PatientRegistration,ModifyField,AddTest,AddGroup,AddDoctor,AddDepartment,AddCategory,DocCommision,ReportByDoc,about,logout;
	Container content;
	JDialog jdbAbout;
	JPanel pHeading,pCenter,pWest,pEast,pNorth,pCommon,pSouth;
	JFrame f;

	public HomePage()
	{
		setTitle("HomePage");
		setSize((int)(Toolkit.getDefaultToolkit().getScreenSize().getWidth()),(int)(Toolkit.getDefaultToolkit().getScreenSize().getHeight())-40);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pHeading=new JPanel(new GridLayout(4,1,10,10));
		pHeading.setBackground(new Color(134,134,234));
		pCenter=new JPanel(new FlowLayout(FlowLayout.CENTER,20,100));
		pWest=new JPanel(new GridBagLayout());
		pNorth=new JPanel(new FlowLayout(FlowLayout.CENTER));
		pEast=new JPanel(new GridBagLayout());
		pCommon=new JPanel(new BorderLayout());
		pSouth=new JPanel(new FlowLayout(FlowLayout.LEFT));

		lName=new JLabel("Welcome to Medi-Scan Diagnostic Lab",SwingConstants.CENTER);
		Font f1=new Font("Goudy Old Style",Font.BOLD,20);
		lName.setFont(f1);
		lName.setForeground(Color.WHITE);
		lTag=new JLabel("Exceptional Technology.ExtraOrdinary care",SwingConstants.CENTER);
		lTag.setFont(f1);
		lTag.setForeground(Color.WHITE);
		lPhone=new JLabel("Phone : 9610271098, 7790877877",SwingConstants.CENTER);
		lPhone.setFont(f1);
		lPhone.setForeground(Color.WHITE);
		lAdmin=new JLabel("Admin Page",SwingConstants.CENTER);
		lAdmin.setFont(f1);
		lAdmin.setForeground(Color.WHITE);

		PatientReport=new JButton("Patient Report");
		Font f2=new Font("Goudy Old Style",Font.BOLD,14);
		PatientReport.setFont(f2);
		 PatientReport.addActionListener(this);
		PatientRegistration=new JButton("PatientRegistration");
		PatientRegistration.setFont(f2);
		PatientRegistration.addActionListener(this);
		ModifyField=new JButton("Modify Field");
		ModifyField.setFont(f2);
		ModifyField.addActionListener(this);
		AddTest=new JButton("Add Test");
		AddTest.setFont(f2);
		AddGroup=new JButton("Add Group");
		AddGroup.setFont(f2);
		AddDoctor=new JButton("Add Doctor");
		AddDoctor.setFont(f2);
		AddDepartment=new JButton("Add Department");
		AddDepartment.setFont(f2);
		AddCategory=new JButton("Add Category");
		AddCategory.setFont(f2);
		DocCommision=new JButton("Doctor Commision Report");
		DocCommision.setFont(f2);
		ReportByDoc=new JButton("Report By Doctor");
		ReportByDoc.setFont(f2);
		about=new JButton("About");
		about.setFont(f2);
		logout=new JButton("Log Out");
		logout.setFont(f2);

		//Adding Icon on top-left.
		ImageIcon img = new ImageIcon("pics/logo.jpg");
		this.setIconImage(img.getImage());

		Icon i=new ImageIcon("pics/Hpic2.jpg");
		JLabel l1=new JLabel(i);



		content=getContentPane();
		//For Button AddTest.
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
		pWest.add(AddTest,gc);
		AddTest.addActionListener(this);
		//For Button AddGroup
		gc=new GridBagConstraints();
		gc.fill = GridBagConstraints.NONE;
		gc.gridx = 1;
		gc.gridwidth = 1;
		gc.gridy = 2;
		gc.ipadx = 10;
		gc.ipady = 0;
		gc.weightx = 0;
		gc.weighty = 0;
		gc.anchor = GridBagConstraints.WEST;
		gc.insets=new Insets(0,0,20,0);
		pWest.add(AddGroup,gc);
		AddGroup.addActionListener(this);
		//For Button AddDoctor
		gc=new GridBagConstraints();
		gc.fill = GridBagConstraints.NONE;
		gc.gridx = 1;
		gc.gridwidth = 1;
		gc.gridy = 3;
		gc.ipadx = 10;
		gc.ipady = 0;
		gc.weightx = 0;
		gc.weighty = 0;
		gc.anchor = GridBagConstraints.WEST;
		gc.insets=new Insets(0,0,20,0);
		pWest.add(AddDoctor,gc);
		AddDoctor.addActionListener(this);
		pWest.setBackground(new Color(211,248,253));

		//For Button AddDepartment
		gc=new GridBagConstraints();
		gc.fill = GridBagConstraints.NONE;
		gc.gridx = 1;
		gc.gridwidth = 1;
		gc.gridy = 1;
		gc.ipadx = 60;
		gc.ipady = 0;
		gc.weightx = 0;
		gc.weighty = 0;
		gc.anchor = GridBagConstraints.EAST;
		gc.insets=new Insets(0,0,20,0);
		pEast.add(AddDepartment,gc);
		AddDepartment.addActionListener(this);

			//For Button AddCategory
		gc=new GridBagConstraints();
		gc.fill = GridBagConstraints.NONE;
		gc.gridx = 1;
		gc.gridwidth = 1;
		gc.gridy = 2;
		gc.ipadx = 80;
		gc.ipady = 0;
		gc.weightx = 0;
		gc.weighty = 0;
		gc.anchor = GridBagConstraints.EAST;
		gc.insets=new Insets(0,0,20,0);
		pEast.add(AddCategory,gc);
		AddCategory.addActionListener(this);

				//For Button DocCommision
		gc=new GridBagConstraints();
		gc.fill = GridBagConstraints.NONE;
		gc.gridx = 1;
		gc.gridwidth = 1;
		gc.gridy = 3;
		gc.ipadx = 10;
		gc.ipady = 0;
		gc.weightx = 0;
		gc.weighty = 0;
		gc.anchor = GridBagConstraints.EAST;
		gc.insets=new Insets(0,0,20,0);
		pEast.add(DocCommision,gc);
		DocCommision.addActionListener(this);

		//For Button ReportByDo
		gc=new GridBagConstraints();
		gc.fill = GridBagConstraints.NONE;
		gc.gridx = 1;
		gc.gridwidth = 1;
		gc.gridy = 4;
		gc.ipadx = 60;
		gc.ipady = 0;
		gc.weightx = 0;
		gc.weighty = 0;
		gc.anchor = GridBagConstraints.EAST;
		gc.insets=new Insets(0,0,20,0);
		pEast.add(ReportByDoc,gc);
		ReportByDoc.addActionListener(this);

		pEast.setBackground(new Color(211,248,253));


		pNorth.add(PatientReport);
		pNorth.add(PatientRegistration);
		pNorth.add(ModifyField);
		pNorth.setBackground(new Color(211,248,253));



		pHeading.add(lName);
		pHeading.add(lTag);
		pHeading.add(lPhone);
		pHeading.add(lAdmin);

		pSouth.add(about);
		pSouth.add(logout);
		pSouth.setBackground(new Color(211,248,253));

		logout.addActionListener(this);
		about.addActionListener(this);

		pCenter.add(l1);
		pCenter.setBackground(new Color(211,248,253));

		pCommon.add(pNorth,BorderLayout.NORTH);
		pCommon.add(pWest,BorderLayout.WEST);
		pCommon.add(pEast,BorderLayout.EAST);
		pCommon.add(pCenter,BorderLayout.CENTER);




		content.add(pHeading,BorderLayout.NORTH);
		content.add(pCommon,BorderLayout.CENTER);

		content.add(pSouth,BorderLayout.SOUTH);
		f=this;
		setVisible(true);

	}


		public void actionPerformed(ActionEvent ae)
		{
			if(ae.getSource()==AddTest)
			{
				this.dispose();
				new AddTest();
			}
			else if(ae.getSource()==AddGroup)
			{
				this.dispose();
				new AddGroup();
			}

			else if(ae.getSource()==AddDoctor)
			{
				this.dispose();
				new AddDoctor();
			}
			else if(ae.getSource()==AddDepartment)
			{
				this.dispose();
				new AddDepartment();
			}
			else if(ae.getSource()==AddCategory)
			{
				this.dispose();
				new AddCategory();
			}
			else if(ae.getSource()==DocCommision)
			{
				this.dispose();
				new DoctorCommisionReport();
			}


				else if(ae.getSource()==ReportByDoc)
			{
				this.dispose();
				new ReportByDoctor();
			}

				else if(ae.getSource()==PatientReport)
			{
				this.dispose();
				new PatientReport();
			}
			else if(ae.getSource()==PatientRegistration)
			{
			this.dispose();
				new PatientRegistration();

			}
			else if(ae.getSource()==logout)
			{
				this.dispose();
				new LoginPage();
			}
			else if(ae.getSource()==about)
			{
				this.dialogAbout();
			}
			else if(ae.getSource()==ModifyField)
			{
				this.dispose();
				new ModifyFields();
			}
			else
			{
				this.dispose();
				new LoginPage();

			}
		}
		public void dialogAbout()
		{
			jdbAbout=new JDialog(f,"About Medi-Scan Diagnostic Lab Services",true);
			jdbAbout.setTitle("About");
			jdbAbout.setSize(440,430);
			jdbAbout.setLocation(250,250);
			jdbAbout.setResizable(false);
			jdbAbout.setLayout(new BorderLayout());
			JPanel h,c,w;

			h=new JPanel();
			h.setBackground(new Color(41,149,239));
			c=new JPanel(new FlowLayout(FlowLayout.CENTER));
			c.setBackground(new Color(211,248,253));
			w=new JPanel();
			w.setBackground(new Color(211,248,253));
			Icon i=new ImageIcon("pics/about.jpg");
			JLabel l1=new JLabel(i);
			h.add(l1);
			Icon i1=new ImageIcon("pics/gelbutton_cross.gif");
			JLabel l2=new JLabel(i1);
			w.add(l2);
			
			Font f3=new Font("Goudy Old Style",Font.BOLD,16);
			JTextArea ab=new JTextArea("A Diagnostic Lab Management System programmed");
			ab.append("\nto manage the information regarding the doctors ,");
			ab.append( "\nthe patients and the test being performed.");
			ab.append("\n\nDeveloped by :");
			ab.append("      Gaurav Nirwal");
			ab.append("\n\t    Peeyush Sachdeva");
			ab.append("\n\n  Under Guidance of :");
			ab.append("     Mr. Amit Jayaswl");
			ab.append("\n\nAll Rights Reserved by :");
			ab.append("\n\nGRRAS Solutions Pvt. Ltd.");
			ab.append("\nOFF:  E-788,789 Avadhpuri,Lalkhoti (JAIPUR)");
			ab.append("\nWEBSITE:  www.grras.org");
			ab.append("\nCALL:  0141-3136868");
			ab.setEditable(false);
			ab.setFont(f3);

			c.add(ab);
			ab.setBackground(new Color(211,248,253));
			jdbAbout.add(h,BorderLayout.NORTH);
			jdbAbout.add(c,BorderLayout.CENTER);
			jdbAbout.add(w,BorderLayout.WEST);
			jdbAbout.setLocationRelativeTo(f);

			jdbAbout.setVisible(true);
		}
}