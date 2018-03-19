/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasichat;

/**
 *
 * @author nano
 */
 import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class AplikasiChat extends javax.swing.JFrame implements Runnable{
Socket client;
ServerSocket server;
BufferedReader rServer, rClient;
BufferedWriter wServer, wClient;
/** Creates new form AplikasiChat */
public AplikasiChat() {
initComponents();
}

@SuppressWarnings("unchecked")

private void initComponents() {

jPanel1 = new javax.swing.JPanel();
jPanel2 = new javax.swing.JPanel();
jLabel1 = new javax.swing.JLabel();
choice = new javax.swing.JComboBox();
connect = new javax.swing.JButton();
username = new javax.swing.JTextField();
jLabel2 = new javax.swing.JLabel();
jScrollPane1 = new javax.swing.JScrollPane();
messages = new javax.swing.JTextArea();
send = new javax.swing.JButton();
content = new java.awt.List();
clear = new javax.swing.JButton();

setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
setResizable(false);

jPanel1.setBackground(new java.awt.Color(0, 51, 51));

jPanel2.setBackground(new java.awt.Color(0, 0, 0));

jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
jLabel1.setForeground(new java.awt.Color(255, 255, 255));
jLabel1.setText("Aplikasi Chat | The Project X");

javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
jPanel2.setLayout(jPanel2Layout);
jPanel2Layout.setHorizontalGroup(
jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
.addContainerGap(229, Short.MAX_VALUE)
.addComponent(jLabel1)
.addGap(19, 19, 19))
);
jPanel2Layout.setVerticalGroup(
jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
.addGroup(jPanel2Layout.createSequentialGroup()
.addContainerGap()
.addComponent(jLabel1)
.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
);

choice.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
choice.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Server", "Client" }));
choice.addItemListener(new java.awt.event.ItemListener() {
public void itemStateChanged(java.awt.event.ItemEvent evt) {
choiceItemStateChanged(evt);
}
});

connect.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
connect.setText("ON");
connect.addActionListener(new java.awt.event.ActionListener() {
public void actionPerformed(java.awt.event.ActionEvent evt) {
connectActionPerformed(evt);
}
});

username.setText("Masukkan Nama Pengguna");
username.addMouseListener(new java.awt.event.MouseAdapter() {
public void mouseClicked(java.awt.event.MouseEvent evt) {
usernameMouseClicked(evt);
}
});

jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
jLabel2.setForeground(new java.awt.Color(255, 255, 255));
jLabel2.setText("Message:");

messages.setColumns(20);
messages.setFont(new java.awt.Font("Segoe Print", 0, 13)); // NOI18N
messages.setRows(5);
messages.setText("Tulis pesan anda disini");
messages.addMouseListener(new java.awt.event.MouseAdapter() {
public void mouseClicked(java.awt.event.MouseEvent evt) {
messagesMouseClicked(evt);
}
});
jScrollPane1.setViewportView(messages);

send.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
send.setText("SEND");
send.addActionListener(new java.awt.event.ActionListener() {
public void actionPerformed(java.awt.event.ActionEvent evt) {
sendActionPerformed(evt);
}
});

clear.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
clear.setText("CLEAR");
clear.addActionListener(new java.awt.event.ActionListener() {
public void actionPerformed(java.awt.event.ActionEvent evt) {
clearActionPerformed(evt);
}
});

javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
jPanel1.setLayout(jPanel1Layout);
jPanel1Layout.setHorizontalGroup(
jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
.addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
.addGroup(jPanel1Layout.createSequentialGroup()
.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
.addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
.addContainerGap()
.addComponent(username))
.addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
.addGap(10, 10, 10)
.addComponent(choice, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
.addComponent(connect, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
.addGap(151, 151, 151))
.addGroup(jPanel1Layout.createSequentialGroup()
.addContainerGap()
.addComponent(jLabel2)
.addContainerGap(346, Short.MAX_VALUE))
.addGroup(jPanel1Layout.createSequentialGroup()
.addContainerGap()
.addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
.addComponent(send, javax.swing.GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
.addContainerGap())
.addGroup(jPanel1Layout.createSequentialGroup()
.addContainerGap()
.addComponent(content, javax.swing.GroupLayout.DEFAULT_SIZE, 392, Short.MAX_VALUE)
.addContainerGap())
.addGroup(jPanel1Layout.createSequentialGroup()
.addContainerGap()
.addComponent(clear, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
.addContainerGap(317, Short.MAX_VALUE))
);
jPanel1Layout.setVerticalGroup(
jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
.addGroup(jPanel1Layout.createSequentialGroup()
.addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
.addGap(18, 18, 18)
.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
.addComponent(connect, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
.addComponent(choice, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE))
.addGap(18, 18, 18)
.addComponent(username, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
.addComponent(jLabel2)
.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
.addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
.addComponent(send, javax.swing.GroupLayout.DEFAULT_SIZE, 67, Short.MAX_VALUE)
.addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
.addGap(27, 27, 27)
.addComponent(content, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
.addComponent(clear, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
.addGap(23, 23, 23))
);

javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
getContentPane().setLayout(layout);
layout.setHorizontalGroup(
layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
.addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
);
layout.setVerticalGroup(
layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
.addGroup(layout.createSequentialGroup()
.addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
);

pack();
java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
java.awt.Dimension dialogSize = getSize();
setLocation((screenSize.width-dialogSize.width)/2,(screenSize.height-dialogSize.height)/2);
}// &lt;/editor-fold&gt;

private void connectActionPerformed(java.awt.event.ActionEvent evt) {
if(connect.getText().equals("CONNECT")){
connect.setText("DISCONNECT");
connection();
Thread thread = new Thread(this);
thread.start();

}else if (choice.getSelectedItem().equals("Server")){
connect.setText("OFF");
readConnection();
Thread thread = new Thread(this);
thread.start();
}
}

private void clearActionPerformed(java.awt.event.ActionEvent evt) {
content.removeAll();
}

private void sendActionPerformed(java.awt.event.ActionEvent evt) {
try{
if(messages.getText().equals("Type your message here")){
messages.setText("");
}
wServer.write(username.getText()+" : "+messages.getText());
wServer.newLine();
wServer.flush();
}
catch (IOException ex) {
Logger.getLogger(AplikasiChat.class.getName()).log(Level.SEVERE, null, ex);
}
content.add("Me : "+messages.getText());
messages.setText("");
}

private void usernameMouseClicked(java.awt.event.MouseEvent evt) {
username.setText("");
}

private void choiceItemStateChanged(java.awt.event.ItemEvent evt) {
if(choice.getSelectedItem().equals("Server")){
connect.setText("ON");
username.setText("Server Username");
}else{
connect.setText("CONNECT");
username.setText("Client Username");
}
}

private void messagesMouseClicked(java.awt.event.MouseEvent evt) {
messages.setText("");
}

public static void main(String args[]) {
try {
for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
if ("Nimbus".equals(info.getName())) {
javax.swing.UIManager.setLookAndFeel(info.getClassName());
break;
}
}
} catch (ClassNotFoundException ex) {
java.util.logging.Logger.getLogger(AplikasiChat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
} catch (InstantiationException ex) {
java.util.logging.Logger.getLogger(AplikasiChat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
} catch (IllegalAccessException ex) {
java.util.logging.Logger.getLogger(AplikasiChat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
} catch (javax.swing.UnsupportedLookAndFeelException ex) {
java.util.logging.Logger.getLogger(AplikasiChat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
}
java.awt.EventQueue.invokeLater(new Runnable() {

public void run() {
new AplikasiChat().setVisible(true);
}
});
}

private void connection(){
try{
String ip = JOptionPane.showInputDialog("Masukkan IP Address: ");
client = new Socket(ip, 2000);
choice.setEnabled(false);
rServer = new BufferedReader(new InputStreamReader(client.getInputStream()));
wServer = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
connect.setText("DISCONNECT");
}catch (UnknownHostException ex){
Logger.getLogger(AplikasiChat.class.getName()).log(Level.SEVERE, null, ex);
JOptionPane.showMessageDialog(this, "Failed to accept!");
System.exit(-1);
}catch (IOException ex) {
Logger.getLogger(AplikasiChat.class.getName()).log(Level.SEVERE, null, ex);

}
}

private void readConnection(){
try{
try{
try{
server = new ServerSocket(2000);
this.setTitle("Please Wait...");
}catch (IOException ex){
JOptionPane.showMessageDialog(null, "Could not listen to the server");
System.exit(-1);
}
client = server.accept();
this.setTitle("CONNECTED"+client.getInetAddress());
}catch (IOException ex) {
Logger.getLogger(AplikasiChat.class.getName()).log(Level.SEVERE, null, ex);
}
rServer = new BufferedReader(new InputStreamReader(client.getInputStream()));
wServer = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
}catch (IOException ex) {
Logger.getLogger(AplikasiChat.class.getName()).log(Level.SEVERE, null, ex);
}
}

private void disClient(){
try{
client.close();
rServer.close();
connect.setEnabled(true);
connect.setText("CONNECT");
}catch (IOException ex) {
Logger.getLogger(AplikasiChat.class.getName()).log(Level.SEVERE, null, ex);
}
}

private void disServer(){
try{
rServer.close();
wServer.close();
setTitle("DISCONNECT");
}catch (IOException ex) {
Logger.getLogger(AplikasiChat.class.getName()).log(Level.SEVERE, null, ex);
}
}
private javax.swing.JComboBox choice;
private javax.swing.JButton clear;
private javax.swing.JButton connect;
private java.awt.List content;
private javax.swing.JLabel jLabel1;
private javax.swing.JLabel jLabel2;
private javax.swing.JPanel jPanel1;
private javax.swing.JPanel jPanel2;
private javax.swing.JScrollPane jScrollPane1;
private javax.swing.JTextArea messages;
private javax.swing.JButton send;
private javax.swing.JTextField username;

@Override
public void run() {
while(true){
try{
content.add(rServer.readLine());
}catch (IOException ex) {
Logger.getLogger(AplikasiChat.class.getName()).log(Level.SEVERE, null, ex);
}
}
}

}