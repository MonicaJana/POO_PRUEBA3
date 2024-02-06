import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import java.awt.Image;
import java.awt.Dimension;

public class ingreso extends JFrame{
    private JPasswordField password;
    private JLabel user;
    private JButton ENTERButton;
    private JPanel panel1;
    private JLabel img;
    private static double dinero=500;
    public ingreso(){
        super("Bienvenido al Banco del Búho");
        setContentPane(panel1);

        // Carga la imagen desde un archivo
        ImageIcon icono = new ImageIcon("BUHO_EPN_big.png"); // Reemplaza con la ruta de tu imagen
        // Establece la imagen en el JLabel
        img.setIcon(icono);
        icono.setImage(icono.getImage().getScaledInstance(100, 150, Image.SCALE_DEFAULT));
        ENTERButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String contra="123456";
                String contraIngresada=password.getText();

                try {
                    if (contra.equals(contraIngresada)) {
                        transaccion tran = new transaccion();
                        tran.iniciar();
                        tran.setLocationRelativeTo(null);
                        dispose();
                    } else {
                        JOptionPane.showMessageDialog(null, "Intentar otra vez");
                        password.setText("");
                    }
                }catch (Exception exception){
                    JOptionPane.showMessageDialog(null,"Ocurrio un error!");
                }
            }
        });
    }
    public void iniciar(){

        setVisible(true);
        setSize(400,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setBackground(new Color(174, 214, 241));
    }
    public double getDinero() {
        return dinero;
    }

    public void setDinero(double dinero) {
        this.dinero = dinero;
    }
}
