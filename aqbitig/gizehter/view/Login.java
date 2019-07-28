package aqbitig.gizehter.view;

import aqbitig.gizehter.controller.MyTreeModel;
import java.util.Arrays;
import javax.swing.JOptionPane;
import aqbitig.gizehter.controller.bridge.InterfaceLogin;
import aqbitig.lib.basic.T;
import java.io.File;

/**
 * gizehter = giz(li) + anahtar
 *
 * @author aqdaycuklu
 */
public class Login extends javax.swing.JPanel {

    aqbitig.gizehter.view.InternalFrame internalFrame;

    File f;
    String mode;

    /**
     * Creates new form InterfaceLogin
     *
     * @param internaleFrame
     */
    public Login(aqbitig.gizehter.view.InternalFrame internalFrame, String mode, File f) {
        this.internalFrame = internalFrame;
        this.f = f;
        this.mode = mode;
        T.o(mode);
        initComponents();

        if (this.mode == "open") {
            jPasswordField2.setVisible(false);
        }

        setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPasswordField1 = new javax.swing.JPasswordField();
        jButtonPassword = new javax.swing.JButton();
        jPasswordField2 = new javax.swing.JPasswordField();

        jPasswordField1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jPasswordField1FocusLost(evt);
            }
        });
        jPasswordField1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPasswordField1MouseClicked(evt);
            }
        });

        jButtonPassword.setText("Password");
        jButtonPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPasswordActionPerformed(evt);
            }
        });

        jPasswordField2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jPasswordField2FocusLost(evt);
            }
        });
        jPasswordField2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPasswordField2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButtonPassword, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPasswordField1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPasswordField2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE))
                .addGap(100, 100, 100))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(81, 81, 81)
                .addComponent(jPasswordField1)
                .addGap(18, 18, 18)
                .addComponent(jPasswordField2)
                .addGap(18, 18, 18)
                .addComponent(jButtonPassword, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(107, 107, 107))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void nextPage(String password) {

        if (this.mode == "open") {
            if (!aqbitig.lib.db.AqbSqlite.checkPassword(f.getPath(), password)) {
                JOptionPane.showMessageDialog(null, "Password not correct.");
                return;
            }
        }

        /*  INTERNEL FRAME TITLE */
        internalFrame.setTitle("Gizehter: " + f.getPath());

        /* SPLIT PANE + TREE */
        aqbitig.gizehter.view.SplitPane sp = new aqbitig.gizehter.view.SplitPane(this.mode, f, password);
        sp.setVisible(true);
        internalFrame.getContentPane().removeAll();
        internalFrame.add(sp);
        /* SPLIT PANE + TREE */

        ((MyTreeModel) sp.getTree().getModel()).populateTree();

        internalFrame.setSplitPane(sp);

    }

    private void jButtonPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPasswordActionPerformed
        // TODO add your handling code here:

        if (this.mode == "open") {
            nextPage(new String(jPasswordField1.getPassword()));
            return;
        }

        if (Arrays.toString(jPasswordField1.getPassword()).equals(Arrays.toString(jPasswordField2.getPassword()))) {
            nextPage(new String(jPasswordField1.getPassword()));
        } else {
            JOptionPane.showMessageDialog(null, "Password incorrect!");
        }
    }//GEN-LAST:event_jButtonPasswordActionPerformed

    private void jPasswordField2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPasswordField2MouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount() == 2 && !evt.isConsumed()) {
            evt.consume();
            jPasswordField2.setEchoChar((char) 0);
        }
    }//GEN-LAST:event_jPasswordField2MouseClicked

    private void jPasswordField2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jPasswordField2FocusLost
        // TODO add your handling code here:
        jPasswordField2.setEchoChar('*');
    }//GEN-LAST:event_jPasswordField2FocusLost

    private void jPasswordField1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPasswordField1MouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount() == 2 && !evt.isConsumed()) {
            evt.consume();
            jPasswordField1.setEchoChar((char) 0);
        }
    }//GEN-LAST:event_jPasswordField1MouseClicked

    private void jPasswordField1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jPasswordField1FocusLost
        // TODO add your handling code here:
        jPasswordField1.setEchoChar('*');
    }//GEN-LAST:event_jPasswordField1FocusLost


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonPassword;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JPasswordField jPasswordField2;
    // End of variables declaration//GEN-END:variables
}
