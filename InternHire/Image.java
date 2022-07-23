/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package booktap;

import java.awt.image.BufferedImage;
import java.io.FileOutputStream;
import java.sql.*;
import javax.swing.ImageIcon;

/**
 *
 * @author sravy
 */
public class Image extends javax.swing.JFrame {

    /**
     * Creates new form Image
     */
    public Image() {
        initComponents();
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel_Image = new javax.swing.JLabel();
        jButton_Retrieve = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel_Image.setPreferredSize(new java.awt.Dimension(200, 200));

        jButton_Retrieve.setText("RETRIEVE");
        jButton_Retrieve.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_RetrieveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(137, 137, 137)
                .addComponent(jLabel_Image, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addComponent(jButton_Retrieve)
                .addContainerGap(129, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(158, 158, 158)
                        .addComponent(jButton_Retrieve))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jLabel_Image, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_RetrieveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_RetrieveActionPerformed
        // TODO add your handling code here:
        String msg = jButton_Retrieve.getText();
        new Resize(msg).setVisible(true);
        setVisible(false);
        try{  
            Class.forName("oracle.jdbc.driver.OracleDriver");  
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","it175","sravya");
            System.out.println("Connection established......");  
			      
            PreparedStatement ps=con.prepareStatement("select * from login where username = 'greeshma'");  
            ResultSet rs=ps.executeQuery();  
            if(rs.next()){
	              
                Blob b=rs.getBlob(3);
		byte barr[]=b.getBytes(1,(int)b.length());
			              
		//FileOutputStream fout=new FileOutputStream("C:\\Users\\sravy\\Desktop\\book3.jpg");  
		//fout.write(barr); 
                ImageIcon icon = new ImageIcon(barr);
                //java.awt.Image image = icon.getImage().getScaledInstance(jLabel_Image.getWidth(), jLabel_Image.getHeight(), java.awt.Image.SCALE_SMOOTH);
                java.awt.Image img = icon.getImage();
                java.awt.Image scale = img.getScaledInstance(jLabel_Image.getWidth(), jLabel_Image.getHeight(),java.awt.Image.SCALE_SMOOTH);
                ImageIcon scaled = new ImageIcon(scale);
                jLabel_Image.setIcon(scaled);                
                
              		              
		//fout.close();  
		}//end of if  
		System.out.println("ok");  
			              
			}catch (Exception e) {
            e.printStackTrace();  
        }  
    }//GEN-LAST:event_jButton_RetrieveActionPerformed

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
            java.util.logging.Logger.getLogger(Image.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Image.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Image.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Image.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Image().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_Retrieve;
    private javax.swing.JLabel jLabel_Image;
    // End of variables declaration//GEN-END:variables
}