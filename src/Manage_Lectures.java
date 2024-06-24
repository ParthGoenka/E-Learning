
import java.awt.Image;
import java.io.File;
import java.util.ArrayList;
import java.util.StringTokenizer;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;


public class Manage_Lectures extends javax.swing.JFrame 
{
    JFileChooser jfc,jfc1;
    File ph,lecture;
    ArrayList<Lecture> al = new ArrayList<>();
    myTableModel tm;
    

    public Manage_Lectures()
    {
        initComponents();
        setSize(800,700);
        load_courses();
        tm = new myTableModel();
        myTable.setModel(tm);
        
    }
    void fetchlectures()
    {
        al.clear();
        
        int course_id = getCourseId((String)cb1.getSelectedItem());
        String ans = myClient.fetchhLectures(course_id);
        StringTokenizer ft = new StringTokenizer(ans,";;");
        while(ft.hasMoreTokens())
        {
            String row = ft.nextToken();
            StringTokenizer ft1 = new StringTokenizer(row,"$");
            int id = Integer.parseInt(ft1.nextToken());
            String name = ft1.nextToken();
            String description = ft1.nextToken();
            String photo = ft1.nextToken();
            al.add(new Lecture(id,name,description,photo));
        }
        tm.fireTableDataChanged();
    }
    class myTableModel extends AbstractTableModel
    {

        @Override
        public int getRowCount() {
            return al.size();
            
            }

        @Override
        public int getColumnCount() {
            return 3;
            }

        @Override
        public Object getValueAt(int i, int j) {
            if(j==0)
            {
               return al.get(i).name;
            }
            else if(j==1)
            {
                return al.get(i).description;
            }
            else
            {
                return al.get(i).photo;
            }
             }
        @Override
        public String getColumnName(int j)
        {
            String name[]={"Name","Description","Photo"};
            return name[j];
        }
        
    }
    
    static int getCourseId(String lecturename)
    {
        String ans = myClient.loadCourses();
        StringTokenizer st = new StringTokenizer(ans,";;");
        while(st.hasMoreTokens())
        {
            String row =st.nextToken();
            StringTokenizer st1 = new StringTokenizer(row,"$");
            int id = Integer.parseInt(st1.nextToken());
            String name = st1.nextToken();
            if (name.equals(lecturename))
            {
              return id;
            }
        }
        return -1;
    }
    
    void load_courses()
    {
        String ans = myClient.loadCourses();
        StringTokenizer st = new StringTokenizer(ans,";;");
        while(st.hasMoreTokens())
        {
            String row =st.nextToken();
            StringTokenizer st1 = new StringTokenizer(row,"$");
            int  id = Integer.parseInt(st1.nextToken());
            String name = st1.nextToken();
            cb.addItem(name);
            cb1.addItem(name);
        
        }
    }
    

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        nametf = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        descriptiontf = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();
        durationtf = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        trailertf = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        photolb = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        cb = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        cb1 = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        myTable = new javax.swing.JTable();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 3, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Manage Lectures");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 800, 30);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel2.setText("Add Lectures");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(100, 20, 100, 20);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel3.setText("View Lectures");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(580, 20, 110, 20);

        jLabel4.setText("Name");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(0, 90, 32, 16);

        nametf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nametfActionPerformed(evt);
            }
        });
        getContentPane().add(nametf);
        nametf.setBounds(0, 110, 300, 22);

        jLabel5.setText("Description");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(0, 150, 90, 20);

        descriptiontf.setColumns(20);
        descriptiontf.setRows(5);
        jScrollPane1.setViewportView(descriptiontf);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(0, 180, 300, 70);

        jLabel6.setText("Duration");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(0, 270, 80, 16);

        durationtf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                durationtfActionPerformed(evt);
            }
        });
        getContentPane().add(durationtf);
        durationtf.setBounds(0, 300, 300, 22);

        jLabel7.setText("Trailer");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(0, 340, 37, 16);
        getContentPane().add(trailertf);
        trailertf.setBounds(0, 370, 300, 22);

        jLabel8.setText("Lecture");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(0, 410, 100, 16);

        jButton1.setText("Browse Lecture");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(0, 440, 200, 23);

        jLabel9.setText("Photo");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(0, 480, 50, 16);
        getContentPane().add(photolb);
        photolb.setBounds(0, 510, 120, 90);

        jButton2.setText("Browse");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(170, 520, 72, 23);

        jButton3.setText("Add");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(170, 560, 72, 23);

        cb.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select" }));
        getContentPane().add(cb);
        cb.setBounds(110, 60, 190, 22);

        jLabel10.setText("Course");
        getContentPane().add(jLabel10);
        jLabel10.setBounds(20, 60, 80, 16);

        jLabel11.setText("Course");
        getContentPane().add(jLabel11);
        jLabel11.setBounds(410, 60, 70, 16);

        cb1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select" }));
        cb1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb1ActionPerformed(evt);
            }
        });
        getContentPane().add(cb1);
        cb1.setBounds(460, 60, 160, 22);

        myTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(myTable);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(410, 100, 370, 340);

        jButton4.setText("Delete");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4);
        jButton4.setBounds(560, 520, 72, 23);

        jButton5.setText("View");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5);
        jButton5.setBounds(660, 60, 72, 23);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void durationtfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_durationtfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_durationtfActionPerformed

    private void nametfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nametfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nametfActionPerformed

    private void cb1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cb1ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        fetchlectures();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        int i= myTable.getSelectedRow();
        if(i == -1)
        {
            JOptionPane.showMessageDialog(rootPane, "Select row");
        }
        else
        {
            int id = al.get(i).id;
            String ans = myClient.deletelecture(id);
            if(ans.trim().equals("success"))
            {
                JOptionPane.showMessageDialog(rootPane, "success");
                fetchlectures();
            }
            else
            {
                JOptionPane.showMessageDialog(rootPane, "faillll");
            }
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        jfc = new JFileChooser();
        int ans = jfc.showOpenDialog(this);
        if(ans == JFileChooser.APPROVE_OPTION)
        {
            ph = jfc.getSelectedFile();
            ImageIcon ic = new ImageIcon(ph.getPath());
            Image img = ic.getImage().getScaledInstance(photolb.getWidth(), photolb.getHeight(), Image.SCALE_SMOOTH);
            ImageIcon ic1 = new ImageIcon(img);
            photolb.setIcon(ic1);
            
            
        }
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        jfc1 = new JFileChooser();
        int ans = jfc1.showOpenDialog(this);
        if(ans == JFileChooser.APPROVE_OPTION)
        {
            lecture=jfc1.getSelectedFile();
            JOptionPane.showMessageDialog(rootPane,"File choosen");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        String lecturename =nametf.getText();
        String lecturedescription =descriptiontf.getText();
        String lectureduration = durationtf.getText();
        String lecturetrailer = trailertf.getText();
        int course_id = getCourseId((String)cb.getSelectedItem());
        String ans = myClient.addlecture(course_id, ph, lecturename, lecturedescription, lectureduration, lecturetrailer, lecture);
        if(ans.trim().equals("success"))
        {
            JOptionPane.showMessageDialog(rootPane, "success");
        }
        else
        {
            JOptionPane.showMessageDialog(rootPane, "fail");
        }
    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(Manage_Lectures.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Manage_Lectures.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Manage_Lectures.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Manage_Lectures.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Manage_Lectures().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cb;
    private javax.swing.JComboBox<String> cb1;
    private javax.swing.JTextArea descriptiontf;
    private javax.swing.JTextField durationtf;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable myTable;
    private javax.swing.JTextField nametf;
    private javax.swing.JLabel photolb;
    private javax.swing.JTextField trailertf;
    // End of variables declaration//GEN-END:variables
}
