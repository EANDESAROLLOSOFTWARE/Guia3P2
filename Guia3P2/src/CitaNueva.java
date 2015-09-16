import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;


public class CitaNueva extends JFrame {

	private static String servidor = "jdbc:sqlserver://10.110.1.32\\lync;databaseName=Guia3P2";
    private static String usuario = "UserGuia3";
    private static String password = "S1s@dm1n";
	private JPanel contentPane;
	public JTextField txtID;
	private JLabel lblFecha;
	private JTextField txtFechaHora;	
	public String Msj;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CitaNueva frame = new CitaNueva();
					frame.setVisible(true);			
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CitaNueva() {
				
		setTitle("Guia3P2 - Historia Clinica - Datos Consulta Medica");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\02\\Dropbox\\A1 - EAN Privado\\Construccion de software\\Guia3P2\\icono.jpg"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 490, 370);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("ID DEL PACIENTE:");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Tahoma", Font.PLAIN, 10));
		label.setBounds(5, 20, 110, 20);
		contentPane.add(label);
		
		lblFecha = new JLabel("FECHA Y HORA");
		lblFecha.setHorizontalAlignment(SwingConstants.CENTER);
		lblFecha.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblFecha.setBounds(245, 20, 100, 20);
		contentPane.add(lblFecha);
		
		txtID = new JTextField();
		txtID.setBackground(new Color(255, 255, 0));
		txtID.setHorizontalAlignment(SwingConstants.CENTER);
		txtID.setForeground(new Color(0, 0, 0));
		txtID.setEditable(false);
		txtID.setToolTipText("ID de paciente");
		txtID.setColumns(10);
		txtID.setBounds(120, 20, 120, 20);
		contentPane.add(txtID);
		
		txtFechaHora = new JTextField();
		txtFechaHora.setBackground(new Color(173, 216, 230));
		txtFechaHora.setHorizontalAlignment(SwingConstants.CENTER);
		txtFechaHora.setToolTipText("fecha y Hora de la consulta");
		txtFechaHora.setForeground(new Color(0, 0, 0));
		txtFechaHora.setEditable(false);
		txtFechaHora.setColumns(10);
		txtFechaHora.setBounds(344, 20, 120, 20);
		contentPane.add(txtFechaHora);		
		SimpleDateFormat SDF = new SimpleDateFormat("dd/M/yyyy hh:mm");
		String vFechaHora = SDF.format(new Date()); 
		txtFechaHora.setText(vFechaHora);			
		JTextPane txtDiagnostico = new JTextPane();	
		txtDiagnostico.setToolTipText("Escriba aca su diagnostico");
		txtDiagnostico.setBounds(10, 69, 440, 230);
		
		contentPane.add(txtDiagnostico);
		
		JButton txtGrabar = new JButton("GRABAR");
		txtGrabar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				 if((txtID.getText().length()==0)||(txtID.getText()==null))
				{
					 Msj = null;
					 Msj = 	"EL CAMPO ID DEL PACIENTE ES NULL.\n"+
							"INGRESE POR LA OPCION GESTION DE PACIENTES";
					 JOptionPane.showMessageDialog(null, Msj,"Historia Clinica",JOptionPane.ERROR_MESSAGE);		
				}
					 		
				else
				{
					try
					{
						String miQuery= "DECLARE @IDVISITA1 int "+
										"INSERT INTO T_VISITAS (ID_PACIENTE, FECHAVISITA) VALUES(?,?) "+
										"SET @IDVISITA1 = (SELECT SCOPE_IDENTITY() AS IDVISITA)"+
										"INSERT INTO T_TRATAMIENTO (ID_VISITA, ID_PACIENTE, OBSERVACIONES, FECHATRATAMIENTO) "+
										"VALUES(@IDVISITA1,?,?,?)";
						
						Connection con = null;
						con = DriverManager.getConnection(servidor, usuario, password);						
						PreparedStatement STM11 = con.prepareStatement(miQuery);					
						STM11.setInt(1, Integer.parseInt(txtID.getText()));					
						STM11.setString(2, vFechaHora);
						STM11.setInt(3, Integer.parseInt(txtID.getText()));	
						STM11.setString(4,txtDiagnostico.getText());
						STM11.setString(5, vFechaHora);					
						int vFilas = STM11.executeUpdate();
						STM11.closeOnCompletion();
						if(vFilas!=0)
						{
							Msj = null;
							Msj = "SE GRABO CORRECTAMENTE LA INFORMACION PARA EL PACIENTE\n";
							JOptionPane.showMessageDialog(null, Msj);
							System.exit(0);
						}						
					}				
					catch (SQLException ex)
					{
						Msj = null;
						Msj = "ERROR: "+ex.getErrorCode()+" "+ex.getMessage(); 
						JOptionPane.showMessageDialog(null,Msj,"Historia Clinica",JOptionPane.ERROR_MESSAGE);  		            
						txtID.requestFocusInWindow();
					}
				}
			}
		});
		txtGrabar.setBounds(184, 310, 89, 23);
		contentPane.add(txtGrabar);		
	}
}
