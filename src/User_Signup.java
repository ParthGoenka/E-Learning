import java.awt.Image;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
public class User_Signup extends javax.swing.JFrame {

    /**
     * Creates new form User_Signup
     */
    JFileChooser jfc;
    File ph;
    public User_Signup() {
        initComponents();
        setSize(1500,1500);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lb = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        emailtf = new javax.swing.JTextField();
        phone = new javax.swing.JTextField();
        passpf = new javax.swing.JPasswordField();
        add = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 3, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("USER SIGNUP");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 500, 60);

        jLabel2.setText("EMAIL");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(30, 120, 60, 20);

        jLabel3.setText("PASSWORD");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(30, 180, 90, 30);

        jLabel4.setText("MOBILE");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(30, 240, 60, 20);

        jLabel5.setText("ADDRESS");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(30, 300, 70, 20);

        jLabel6.setText("PHOTO");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(30, 360, 60, 16);

        lb.setText("add photo by clicking browse");
        getContentPane().add(lb);
        lb.setBounds(170, 350, 170, 100);

        jButton1.setText("BROWSE");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(375, 413, 120, 30);
        getContentPane().add(emailtf);
        emailtf.setBounds(170, 120, 320, 30);
        getContentPane().add(phone);
        phone.setBounds(170, 240, 320, 30);
        getContentPane().add(passpf);
        passpf.setBounds(170, 180, 320, 30);
        getContentPane().add(add);
        add.setBounds(170, 300, 310, 40);

        jButton2.setText("SUBMIT");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(170, 463, 120, 30);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        jfc = new JFileChooser();
        int ans = jfc.showOpenDialog(this);
        if(ans== JFileChooser.APPROVE_OPTION)
        {
            ph = jfc.getSelectedFile();
            ImageIcon ic = new ImageIcon(ph.getPath());
            Image img = ic.getImage().getScaledInstance(lb.getWidth(),lb.getHeight(),Image.SCALE_SMOOTH);
            ImageIcon ic1 = new ImageIcon(img);
            lb.setIcon(ic1);
        }
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        String email = emailtf.getText();
        String pass = passpf.getText();
        String mobile = phone.getText();
        String address = add.getText();
        
        if(email.isEmpty()||pass.isEmpty()||mobile.isEmpty()||address.isEmpty()||ph==null)
        {
            JOptionPane.showMessageDialog(rootPane, "All fields are mandatory");
        }
        else
        {
            String ans = myClient.Signup(email, pass, mobile, address, ph);
            
            if(ans.equals("success"))
            {
                JOptionPane.showMessageDialog(rootPane, "Signup Success");
            }
            else if(ans.equals("exist"))
            {
                JOptionPane.showMessageDialog(rootPane, "User already exist");
            }
            else
            {
                JOptionPane.showMessageDialog(rootPane, ans);
            }
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(User_Signup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(User_Signup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(User_Signup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(User_Signup.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new User_Signup().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField add;
    private javax.swing.JTextField emailtf;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel lb;
    private javax.swing.JPasswordField passpf;
    private javax.swing.JTextField phone;
    // End of variables declaration//GEN-END:variables
}
