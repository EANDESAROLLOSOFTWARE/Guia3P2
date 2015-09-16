import java.awt.EventQueue;
import java.sql.*;
import java.util.Calendar;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import java.awt.Toolkit;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;


public class ClienteNuevo {
	
	private static String servidor = "jdbc:sqlserver://10.110.1.32\\lync;databaseName=Guia3P2";
    private static String usuario = "UserGuia3";
    private static String password = "S1s@dm1n";
	public JFrame fClienteNuevo;
	public static JTextField txtApellidos;
	public static JTextField txtNombres;
	public static JTextField txtID;	
	public static JTextArea txtDireccion;
	public JButton btnAccion;
	public static JRadioButton opcMujer;
	public static JRadioButton opcHombre;	
	public static ButtonGroup opcSexo;
	public JComboBox<?> cbxMes;
	public JComboBox<?> cbxDia;
	private JTextField txtTelefono;
	private JTextField txtEdad;
	private int vSexo;
	private int vCiudad;
	private String vMes;
	private int vMesi;
	private int vDia;
	private int vValidado;
	private String Msj;
	public String vNombres;
	public String vApellidos;
	private String vDireccion;
	public int vID;
	private static int iAAAA=1915;
	private int fAAAA;	
	
	
	
	private void Campos0()
	{
		
		txtNombres.setEnabled(false);
		txtNombres.setText(null);
		txtApellidos.setEnabled(false);
		txtApellidos.setText(null);		
		txtTelefono.setEnabled(false);
		txtTelefono.setText(null);			
		txtTelefono.setEnabled(false);
		txtTelefono.setText(null);		
	}
	
	private void FMes(String Mes)
	{
		switch(Mes)
		{
		case "ENERO": vMesi = 1;
		break;
		case "FEBRERO": vMesi = 2;
		break;
		case "MARZO": vMesi = 3;
		break;
		case "ABRIL": vMesi = 4;
		break;
		case "MAYO": vMesi = 5;
		break;
		case "JUNIO": vMesi = 6;
		break;
		case "JULIO": vMesi = 7;
		break;
		case "AGOSTO": vMesi = 8;
		break;
		case "SEPTIEMBRE": vMesi = 9;
		break;
		case "OCTUBRE": vMesi = 10;
		break;
		case "NOVIEMBRE": vMesi = 11;
		break;
		case "DICIEMBRE": vMesi = 12;
		break;
		}
	}
	
	private void FDia(String Mes)
	{
		switch(Mes)
		{
		case "ENERO": vDia = 31;
		break;
		case "FEBRERO": vDia = 28;
		break;
		case "MARZO": vDia = 30;
		break;
		case "ABRIL": vDia = 30;
		break;
		case "MAYO": vDia = 31;
		break;
		case "JUNIO": vDia = 30;
		break;
		case "JULIO": vDia = 31;
		break;
		case "AGOSTO": vDia = 31;
		break;
		case "SEPTIEMBRE": vDia = 30;
		break;
		case "OCTUBRE": vDia = 31;
		break;
		case "NOVIEMBRE": vDia = 30;
		break;
		case "DICIEMBRE": vDia = 31;
		break;
		}
	}
	
	public String RetorneValores()
	{
		return vApellidos;
	}

	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClienteNuevo window = new ClienteNuevo();
					window.fClienteNuevo.setVisible(true);					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public ClienteNuevo() {
		initialize();
	}

	
	public void initialize() {
		
		Calendar calendario = Calendar.getInstance(); 
		fAAAA = calendario.get(Calendar.YEAR);
		
		fClienteNuevo = new JFrame();
		fClienteNuevo.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\02\\Dropbox\\A1 - EAN Privado\\Construccion de software\\Guia3P2\\icono.jpg"));
		fClienteNuevo.getContentPane().setEnabled(false);
		fClienteNuevo.setTitle("Guia3P2 - Historia Clinica - Gesti\u00F3n de Pacientes");
		fClienteNuevo.setBounds(100, 100, 490, 370);
		fClienteNuevo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fClienteNuevo.getContentPane().setLayout(null);
		
		JLabel lblID = new JLabel("ID DEL PACIENTE:");
		lblID.setHorizontalAlignment(SwingConstants.RIGHT);
		lblID.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblID.setBounds(22, 40, 135, 20);
		fClienteNuevo.getContentPane().add(lblID);
		
		JLabel lblNombres = new JLabel("NOMBRES DEL PACIENTE:");
		lblNombres.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNombres.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNombres.setBounds(22, 70, 135, 20);
		fClienteNuevo.getContentPane().add(lblNombres);
		
		JLabel lblApellidos = new JLabel("APELLIDOS DEL PACIENTE:");
		lblApellidos.setHorizontalAlignment(SwingConstants.RIGHT);
		lblApellidos.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblApellidos.setBounds(22, 100, 135, 20);
		fClienteNuevo.getContentPane().add(lblApellidos);
		
		JLabel lblSexo = new JLabel("SEXO: ");
		lblSexo.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSexo.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblSexo.setBounds(22, 130, 135, 20);
		fClienteNuevo.getContentPane().add(lblSexo);
		
		JLabel lblCiudad = new JLabel("LUGAR DE NACIMIENTO ");
		lblCiudad.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCiudad.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblCiudad.setBounds(22, 160, 135, 20);
		fClienteNuevo.getContentPane().add(lblCiudad);
		
		JLabel lblDireccion = new JLabel("DIRECCION:");
		lblDireccion.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDireccion.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblDireccion.setBounds(22, 220, 135, 20);
		fClienteNuevo.getContentPane().add(lblDireccion);
		
		JLabel lblTelefono = new JLabel("TELEFONO:");
		lblTelefono.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTelefono.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblTelefono.setBounds(22, 270, 135, 20);
		fClienteNuevo.getContentPane().add(lblTelefono);
		
		JLabel lblEdad = new JLabel("EDAD:");
		lblEdad.setHorizontalAlignment(SwingConstants.LEFT);
		lblEdad.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblEdad.setBounds(345, 160, 40, 20);
		fClienteNuevo.getContentPane().add(lblEdad);
		
		txtID = new JTextField();
		txtID.setToolTipText("Digite el ID del paciente que desea validar");
		txtID.setColumns(10);
		txtID.setBounds(170, 40, 120, 20);		
		fClienteNuevo.getContentPane().add(txtID);		
		
		txtApellidos = new JTextField();
		txtApellidos.setEnabled(false);
		txtApellidos.setToolTipText("Digite APELLIDOS");
		txtApellidos.setBounds(170, 100, 266, 20);
		fClienteNuevo.getContentPane().add(txtApellidos);
		txtApellidos.setColumns(10);
		
		txtNombres = new JTextField();
		txtNombres.setEnabled(false);
		txtNombres.setToolTipText("Digite NOMBRES");
		txtNombres.setColumns(10);
		txtNombres.setBounds(170, 70, 266, 20);
		fClienteNuevo.getContentPane().add(txtNombres);
		
		JRadioButton opcMujer = new JRadioButton("Femenino");
		opcMujer.setEnabled(false);
		opcMujer.setBounds(174, 130, 100, 20);
		fClienteNuevo.getContentPane().add(opcMujer);
		
		JRadioButton opcHombre = new JRadioButton("Masculino");
		opcHombre.setEnabled(false);
		opcHombre.setBounds(285, 130, 100, 20);
		fClienteNuevo.getContentPane().add(opcHombre);
				
		ButtonGroup opcSexo = new ButtonGroup();
		opcSexo.add(opcMujer);
		opcSexo.add(opcHombre);
				
		JComboBox<String> cbxCiudad = new JComboBox<String>();
		cbxCiudad.setFont(new Font("Tahoma", Font.PLAIN, 10));
		cbxCiudad.setEnabled(false);
		cbxCiudad.setBounds(170, 160, 110, 20);
		
				
		Connection con = null;
		try
		{
            con = DriverManager.getConnection(servidor, usuario, password);
			String miQuery2="SELECT ID_CIUDAD, CIUDAD FROM T_CIUDAD ORDER BY CIUDAD ASC";
			Statement STM2 = con.createStatement();
			ResultSet RS2 = STM2.executeQuery(miQuery2);			
            while(RS2.next())
            {            	   
            	cbxCiudad.addItem(RS2.getString("CIUDAD"));
            }
		}     		
		catch (SQLException ex)
        {
            String Msj = "ERROR: "+ex.getErrorCode()+" "+ex.getMessage(); 
            JOptionPane.showMessageDialog(null,Msj,"Historia Clinica",JOptionPane.ERROR_MESSAGE);                
            System.exit(1);
        }
		
	
		fClienteNuevo.getContentPane().add(cbxCiudad);		
		JTextArea txtDireccion = new JTextArea();
		txtDireccion.setFont(new Font("Tahoma", Font.PLAIN, 10));
		txtDireccion.setRows(2);
		txtDireccion.getMaximumSize();
		
		txtEdad = new JTextField();
		txtEdad.setHorizontalAlignment(SwingConstants.CENTER);
		txtEdad.setText("??");
		txtEdad.setEditable(false);
		txtEdad.setToolTipText("Edad del paciente");
		txtEdad.setColumns(10);
		txtEdad.setBounds(396, 160, 40, 20);
		fClienteNuevo.getContentPane().add(txtEdad);
		
		txtDireccion.setEnabled(false);
		txtDireccion.setBounds(170, 220, 266, 40);
		fClienteNuevo.getContentPane().add(txtDireccion);
		
		txtTelefono = new JTextField();
		txtTelefono.setEnabled(false);
		txtTelefono.setColumns(10);
		txtTelefono.setBounds(170, 270, 140, 20);
		fClienteNuevo.getContentPane().add(txtTelefono);
		JComboBox<?> cbxMes = new JComboBox();
		cbxMes.setModel(new DefaultComboBoxModel(new String[] {"","ENERO", "FEBRERO", "MARZO", "ABRIL", "MAYO", "JUNIO", "JULIO", "AGOSTO", "SEPTIEMBRE", "OCTUBRE", "NOVIEMBRE", "DICIEMBRE"}));
		cbxMes.setToolTipText("MES DE NACIMIENTO");
		cbxMes.setFont(new Font("Tahoma", Font.PLAIN, 10));
		cbxMes.setBounds(170, 190, 90, 20);
		fClienteNuevo.getContentPane().add(cbxMes);
		cbxMes.setSelectedIndex(0);
				
		JComboBox<Integer> cbxDia = new JComboBox<Integer>();
		cbxDia.setToolTipText("DIA DE NACIMIENTO");
		cbxDia.setFont(new Font("Tahoma", Font.PLAIN, 10));
		cbxDia.setBounds(280, 190, 70, 20);
		fClienteNuevo.getContentPane().add(cbxDia);		
		
		JComboBox<Integer> cbxAAAA = new JComboBox<Integer>();
		cbxAAAA.setToolTipText("A\u00D1O DE NACMIENTO");
		cbxAAAA.setFont(new Font("Tahoma", Font.PLAIN, 10));
		cbxAAAA.setBounds(367, 190, 70, 20);
		fClienteNuevo.getContentPane().add(cbxAAAA);
		
		int i;
		for (i=iAAAA;i<=fAAAA;i++)
		{
			cbxAAAA.addItem(i);
		}
		
		cbxAAAA.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				int vF1 = Integer.parseInt(cbxAAAA.getSelectedItem().toString());
				int vF2 = fAAAA-vF1;
				String vF2TXT = Integer.toString(vF2);
				txtEdad.setText(vF2TXT);			
			}
		});
		
		cbxMes.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				cbxDia.removeAllItems();
				vMes = cbxMes.getSelectedItem().toString();
				vDia = 0;
				FDia(vMes);
				int i;
				for(i=1;i<=vDia;i++)
				{
					cbxDia.addItem(i);
				}			
			}
		});
		
		
		btnAccion = new JButton("PACIENTE EXISTE?");
		btnAccion.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnAccion.setHorizontalAlignment(SwingConstants.LEFT);
		btnAccion.setEnabled(true);
		btnAccion.setBounds(85, 301, 125, 20);
		fClienteNuevo.getContentPane().add(btnAccion);
		
		JButton btnGrabar = new JButton("GRABAR PACIENTE");
		btnGrabar.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnGrabar.setHorizontalAlignment(SwingConstants.LEFT);
		btnGrabar.setEnabled(false);
		btnGrabar.setBounds(281, 301, 125, 20);		
		fClienteNuevo.getContentPane().add(btnGrabar);
		fClienteNuevo.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{txtID, txtNombres, txtApellidos, opcMujer, opcHombre, cbxCiudad, cbxMes, cbxDia, cbxAAAA, txtTelefono, txtDireccion, btnAccion, btnGrabar}));
		
				
		btnGrabar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				if(opcMujer.isSelected()==true)
				{
					vSexo = 0;
				}
				else
				{
					vSexo = 1;
				}				
				vNombres = txtNombres.getText().toUpperCase();
				vApellidos = txtApellidos.getText().toUpperCase();	
				vDireccion = txtDireccion.getText().toUpperCase();				
				Connection con = null;
				try
				{
		            con = DriverManager.getConnection(servidor, usuario, password);
		            String miQuery3 = "SELECT ID_CIUDAD  FROM T_CIUDAD WHERE CIUDAD='"+cbxCiudad.getSelectedItem()+"'";
					Statement STM3 = con.createStatement();
					ResultSet RS3 = STM3.executeQuery(miQuery3);			
		            while(RS3.next())
		            {            	   
		            	vCiudad = RS3.getInt("ID_CIUDAD");
		            }
		            STM3.close();
		            RS3.close();
		            con.close();
				}     		
				catch (SQLException ex)
		        {					
					String Msj = "ERROR: "+ex.getErrorCode()+" "+ex.getMessage(); 
			        JOptionPane.showMessageDialog(null,Msj,"Historia Clinica",JOptionPane.ERROR_MESSAGE);             
		            Campos0();
		        }				
								
				try
				{						
						if((vValidado!=1)&&(txtID.getText().length()>1)&&(txtID.getText().length()<11)&&(txtApellidos.getText().length()!=0)&&(txtNombres.getText().length()!=0)&&(txtDireccion.getText().length()>4)&&(txtDireccion.getText().length()<59)&&(txtTelefono.getText().length()>6)&&(txtTelefono.getText().length()<11)&&(cbxMes.getSelectedItem()!=null)&&(cbxDia.getSelectedItem()!=null))
						{
							vMes = cbxMes.getSelectedItem().toString();
							FMes(vMes);					
							String vSFecha = vMesi+"/"+cbxDia.getSelectedItem().toString()+"/"+cbxAAAA.getSelectedItem().toString();
								
							con = DriverManager.getConnection(servidor, usuario, password);
							String miQuery4 = "INSERT INTO T_PACIENTES(ID_PACIENTE,NOMBRES,APELLIDOS,SEXO,DIRECCION,TELEFONO,ID_CIUDAD,FECHANACIMIENTO)\n";
							miQuery4 = miQuery4+"VALUES ("+txtID.getText()+",'"+vNombres+"','"+vApellidos+"',"+vSexo;
							miQuery4 = miQuery4+",'"+vDireccion+"','"+txtTelefono.getText()+"',"+vCiudad+",'"+vSFecha+"')\n";
							JOptionPane.showMessageDialog(null, "QUERY: "+miQuery4);
							Statement STM4 = con.createStatement();
							int vFilas = STM4.executeUpdate(miQuery4);
							STM4.closeOnCompletion();
							if(vFilas!=0)
							{
								Msj = "USUARIO: "+txtID.getText()+"\n";
								Msj = Msj+"APELLIDOS: "+vApellidos+"\n";
								Msj = Msj+"NOMBRES: "+vNombres+"\n";
								Msj = Msj+"SE GRABO CON EXITO\n";
								JOptionPane.showMessageDialog(null, Msj);
								Campos0();
								txtID.setText(null);	
								btnGrabar.setEnabled(false);
							}							
						}
						else
						{
						
							if((txtID.getText().length()<2)|(txtID.getText().length()>10))
							{
									Msj = null;
									Msj = "ERROR: CAMPO ID PACIENTE INVALIDO\n";
									Msj = Msj+"EL CAMPO DEBE TENER MINOMO 2 DIGITOS\n";
									Msj = Msj+"EL CAMPO DEBE TENER MAXIMO 10 DIGITOS\n";
									JOptionPane.showMessageDialog(null, Msj,"Historia Clinica",JOptionPane.WARNING_MESSAGE);
									txtID.requestFocusInWindow();
									txtID.setText(null);
									Campos0();
							}
							
							else if(txtNombres.getText().length()==0)
							{
								JOptionPane.showMessageDialog(null, "ERROR: CAMPO NOMBRES ES NULL","Historia Clinica",JOptionPane.WARNING_MESSAGE);
								txtNombres.requestFocusInWindow();
							}
							else if(txtApellidos.getText().length()==0)
							{
								JOptionPane.showMessageDialog(null, "ERROR: CAMPO APELLIDOS ES NULL","Historia Clinica",JOptionPane.WARNING_MESSAGE);
								txtApellidos.requestFocusInWindow();
							}
							else if((txtDireccion.getText().length()<5)||txtDireccion.getText().length()>59)
							{
								Msj = null;
								Msj = "ERROR: CAMPO DIRECCION INVALIDO\n";
								Msj = Msj+"EL CAMPO DEBE TENER MINOMO 5 CARACTERES\n";
								Msj = Msj+"EL CAMPO DEBE TENER MAXIMO 59 CARACTERES\n";
								JOptionPane.showMessageDialog(null, Msj,"Historia Clinica",JOptionPane.WARNING_MESSAGE);
								txtDireccion.requestFocusInWindow();
								txtDireccion.setText(null);
							}
							else if((txtTelefono.getText().length()<7)||(txtTelefono.getText().length()>10))
							{
								Msj = null;
								Msj = "ERROR: CAMPO TELEFONO\n";
								Msj = Msj+"EL CAMPO DEBE TENER MINOMO 7 DIGITOS\n";
								Msj = Msj+"EL CAMPO DEBE TENER MAXIMO 10 DIGITOS\n";
								JOptionPane.showMessageDialog(null, Msj,"Historia Clinica",JOptionPane.WARNING_MESSAGE);
								txtTelefono.requestFocusInWindow();
								txtTelefono.setText(null);
							}
							else if((cbxMes.getSelectedItem()=="")&&(cbxDia.getSelectedItem()==null))
							{
								Msj=null;
								Msj = "EL CAMPO MESO DIA ES NULL\n";
								JOptionPane.showMessageDialog(null, Msj,"Historia Clinica",JOptionPane.WARNING_MESSAGE);
								cbxMes.requestFocusInWindow();
								Campos0();
							}
							
							else
							{
								JOptionPane.showMessageDialog(null, "ERROR, EL ID YA ESTA GRANBADO","Historia Clinica",JOptionPane.WARNING_MESSAGE);
							}
							
						}
						
				}
				
				catch (SQLException ex)
		        {
					String Msj = "ERROR: "+ex.getErrorCode()+" "+ex.getMessage(); 
			        JOptionPane.showMessageDialog(null,Msj,"Historia Clinica",JOptionPane.ERROR_MESSAGE);                
			        Campos0();
		            txtID.requestFocusInWindow();
		        }
			}
		});				

		//Codigo que ejecuta el dar CLIC en botor "VALIDAR", valida la existencia del paciente, si no existe habilita los controles para ingresar la informacion del nuevo pamciente.
		//Se el paciente existe en la BD, trae los datos de este y solicita al usuario si desea ingresar los datos medicos.		

		btnAccion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				String vID = txtID.getText();				
				if((vID==null)|(vID.length()==0))
				{
					JOptionPane.showMessageDialog(null, "EL CAMPO ID NO ES VALIDO!!","Historia Clinica",JOptionPane.WARNING_MESSAGE);
					txtID.requestFocusInWindow();
					Campos0();
				}
				else
				{
					String miQuery1 = "SELECT COUNT(ID_PACIENTE) as Validado FROM T_PACIENTES WHERE ID_PACIENTE="+vID;	
					Connection con = null;
					try
					{
			            con = DriverManager.getConnection(servidor, usuario, password);
			            Statement STM1 = con.createStatement();
			            ResultSet RS1= STM1.executeQuery(miQuery1);            
			            while(RS1.next())
			            {
			            	vValidado= RS1.getInt("Validado");			            	
			        		if(vValidado!=0)
			        		{
			        			String miQuery2 = "SELECT ID_PACIENTE, NOMBRES, APELLIDOS, SEXO, CIUDAD, DIRECCION, TELEFONO FROM T_PACIENTES A ";
			        			miQuery2 = miQuery2+"LEFT JOIN T_CIUDAD B ON A.ID_CIUDAD = B.ID_CIUDAD WHERE ID_PACIENTE="+txtID.getText();
			        			Statement STM2 = con.createStatement();
			                    ResultSet RS2 = STM2.executeQuery(miQuery2);
			                                     
			                    	while(RS2.next())
			                    	{
			                    			Campos0();
			                    			opcMujer.setEnabled(false);
			                    			opcHombre.setEnabled(false);
			                    			cbxCiudad.setEnabled(false);
			                    			txtDireccion.setEnabled(false);
			                    			txtID.requestFocusInWindow();
			                    			txtNombres.setText(RS2.getString("Nombres"));
			                    			txtApellidos.setText(RS2.getString("Apellidos"));
			                    			txtDireccion.setText(RS2.getString("Direccion"));
			                    			txtTelefono.setText(RS2.getString("Telefono"));
			                    			if(RS2.getInt("SEXO")==0)
			                    				{
			                    					opcMujer.setSelected(true);			                    				    
			                    				}
			                    				else
			                    				{
			                    					opcHombre.setSelected(true);			                    				
			                    				}
			                    					cbxCiudad.setSelectedItem(RS2.getString("CIUDAD"));
			                    	}
			                    	Msj = null;
				        			Msj = "ID DE PACIENTE EXISTENTE: "+txtID.getText();
				        			Msj = Msj+"\nDESEA INGRESAR DATOS MEDICOS DEL PACIENTE?";			        			
				        			int Opc = JOptionPane.showConfirmDialog(null,Msj);
				        			vID = txtID.getText();
	                    			vApellidos = txtApellidos.getText();
	                    			vNombres = txtNombres.getText();	
	                    			CitaNueva NuevaCita = new CitaNueva();
	                    			NuevaCita.txtID.setText(vID);
	                    			NuevaCita.setVisible(true);
				        			//JOptionPane.showMessageDialog(null, "variables:"+vApellidos+vNombres+vID);
				        			btnGrabar.setEnabled(false);				        			
			                 }			                    						                    
			                    	
			        		else
			        		{
			        			Campos0();
			        			opcSexo.clearSelection();
			        			txtNombres.setEnabled(true);
			        			txtApellidos.setEnabled(true);			        			
			        			txtTelefono.setEnabled(true);	
			        			opcHombre.setEnabled(true);
			        			opcMujer.setEnabled(true);			        			
			        			txtDireccion.setText(null);
			        			txtDireccion.setEnabled(true);
			        			txtNombres.requestFocusInWindow();
			        			btnGrabar.setEnabled(true);
			        			cbxCiudad.setEnabled(true);			        			
			        		}			        		
			            } 
			            STM1.close();
			            RS1.close();
					}    		
					catch (SQLException ex)
			        {
						String Msj = "ERROR: "+ex.getErrorCode()+" "+ex.getMessage(); 
				        JOptionPane.showMessageDialog(null,Msj,"Historia Clinica",JOptionPane.ERROR_MESSAGE);   			          			            
			            Campos0();
			        }
					
				}
			}
		});	
			
	}
	 	
}

