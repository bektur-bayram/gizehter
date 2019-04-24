package aqbitig.gizehter.view;

import aqbitig.gizehter.model.MyAtomic;
import aqbitig.lib.basic.T;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 * gizehter = giz(li) + anahtar
 *
 * @author aqdaycuklu
 */
public class Info extends javax.swing.JPanel {

    MyAtomic node;
    char passwordChar;
    DocumentListener documentListener;

    /**
     * Creates new form input
     */
    public Info() {
        initComponents();
        setListener();
        this.passwordChar = jPasswordFieldPassword.getEchoChar();
    }

    /* LISTENERS */
    private void setListener() {
        this.documentListener = new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                T.o();
                jButtonSave.setEnabled(true);
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                T.o();
                jButtonSave.setEnabled(true);
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                T.o();
            }
        };
        this.jTextFieldLogin.getDocument().addDocumentListener(this.documentListener);
        this.jPasswordFieldPassword.getDocument().addDocumentListener(this.documentListener);
        this.jTextFieldUrl.getDocument().addDocumentListener(this.documentListener);
        this.jTextPaneComment.getDocument().addDocumentListener(this.documentListener);

        this.jLabelPassword.addMouseListener(new MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent e) {
                T.o(e.getClickCount());
                if (e.getClickCount() == 2) {
                    T.copyToClipboard(new String(jPasswordFieldPassword.getPassword()));
                }
            }
        });
    }

    /* LISTENERS. */
    public MyAtomic getNode() {
        return node;
    }

    public void setNode(MyAtomic node) {
        this.node = node;
        this.jTextFieldLogin.setText(node.getLogin());
        this.jPasswordFieldPassword.setText(node.getPassword());
        this.jTextFieldUrl.setText(node.getUrl());
        this.jTextPaneComment.setText(node.getComment());
        this.jLabel1.setText("PATH[" + node.getPath() + "] - LEVEL[" + node.getLevel() + "] - INDEX[" + node.getIndex() + "]");
    }

    public void clear() {
        this.jTextFieldLogin.setText("");
        this.jPasswordFieldPassword.setText("");
        this.jTextFieldUrl.setText("");
        this.jTextPaneComment.setText("");
        this.jLabel1.setText("");
    }

    public void activate() {
        this.jTextFieldLogin.setEnabled(true);
        this.jPasswordFieldPassword.setEnabled(true);
        this.jTextFieldUrl.setEnabled(true);
        this.jTextPaneComment.setEnabled(true);
        this.jButtonSave.setEnabled(false);

    }

    public void deactivate() {
        this.jTextFieldLogin.setEnabled(false);
        this.jPasswordFieldPassword.setEnabled(false);
        this.jTextFieldUrl.setEnabled(false);
        this.jTextPaneComment.setEnabled(false);
        this.jButtonSave.setEnabled(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextFieldLogin = new javax.swing.JTextField();
        jLabelLogin = new javax.swing.JLabel();
        jLabelPassword = new javax.swing.JLabel();
        jLabelUrl = new javax.swing.JLabel();
        jTextFieldUrl = new javax.swing.JTextField();
        jPasswordFieldPassword = new javax.swing.JPasswordField();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPaneComment = new javax.swing.JTextPane();
        jButtonSave = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        jTextFieldLogin.setText("");

        jLabelLogin.setText("Login");

        jLabelPassword.setText("Password");

        jLabelUrl.setText("Url");

        jTextFieldUrl.setText("");

        jPasswordFieldPassword.setText("");
        jPasswordFieldPassword.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jPasswordFieldPasswordFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jPasswordFieldPasswordFocusLost(evt);
            }
        });

        jScrollPane1.setViewportView(jTextPaneComment);

        jButtonSave.setText("Hold");
        jButtonSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSaveActionPerformed(evt);
            }
        });

        jLabel1.setText("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(jSeparator1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelLogin)
                            .addComponent(jLabelPassword)
                            .addComponent(jLabelUrl))
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldLogin, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                            .addComponent(jTextFieldUrl, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPasswordFieldPassword)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonSave)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelLogin))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelPassword)
                    .addComponent(jPasswordFieldPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelUrl)
                    .addComponent(jTextFieldUrl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButtonSave, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSaveActionPerformed
        // TODO add your handling code here:
        node.setLogin(jTextFieldLogin.getText());
        node.setPassword(String.valueOf(jPasswordFieldPassword.getPassword()));
        node.setUrl(jTextFieldUrl.getText());
        node.setComment(jTextPaneComment.getText());
        this.jButtonSave.setEnabled(false);
    }//GEN-LAST:event_jButtonSaveActionPerformed

    private void jPasswordFieldPasswordFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jPasswordFieldPasswordFocusGained
        // TODO add your handling code here:
        jPasswordFieldPassword.setEchoChar((char) 0);
    }//GEN-LAST:event_jPasswordFieldPasswordFocusGained

    private void jPasswordFieldPasswordFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jPasswordFieldPasswordFocusLost
        // TODO add your handling code here:
        jPasswordFieldPassword.setEchoChar(this.passwordChar);
    }//GEN-LAST:event_jPasswordFieldPasswordFocusLost


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonSave;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelLogin;
    private javax.swing.JLabel jLabelPassword;
    private javax.swing.JLabel jLabelUrl;
    private javax.swing.JPasswordField jPasswordFieldPassword;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jTextFieldLogin;
    private javax.swing.JTextField jTextFieldUrl;
    private javax.swing.JTextPane jTextPaneComment;
    // End of variables declaration//GEN-END:variables

}
