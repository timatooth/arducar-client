package com.timatooth.carclient;

import java.awt.BorderLayout;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JSlider;
import javax.swing.UIManager;

/**
 *
 * @author tim
 */
public class Main extends javax.swing.JFrame {

    private CarConnection connection;
    private int yawPosition, pitchPosition;
    private final Map<String, Boolean> actions;
    private NetWriteThread writeThread;
    private MjpegPanel mjpegPanel;

    /**
     * Creates new form MainFrame
     */
    public Main() {
        initComponents();
        yawPosition = 90;
        pitchPosition = 90;
        actions = new ConcurrentHashMap<>();
        actions.put("left", false);
        actions.put("right", false);
        actions.put("forward", false);
        actions.put("backward", false);
        actions.put("horn", false);
        pnlVideo.setLayout(new BorderLayout());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblHostname = new javax.swing.JLabel();
        txtHostname = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtPort = new javax.swing.JTextField();
        btnConnect = new javax.swing.JButton();
        sldPitch = new javax.swing.JSlider();
        pnlVideo = new javax.swing.JPanel();
        sldYaw = new javax.swing.JSlider();
        tabStatsPane = new javax.swing.JTabbedPane();
        pnlStats = new javax.swing.JPanel();
        btnLeft = new javax.swing.JButton();
        btnRight = new javax.swing.JButton();
        btnBackward = new javax.swing.JButton();
        btnForward = new javax.swing.JButton();
        btnHorn = new javax.swing.JButton();
        proBattery = new javax.swing.JProgressBar();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        proSigStrength = new javax.swing.JProgressBar();
        jLabel4 = new javax.swing.JLabel();
        proSigQuality = new javax.swing.JProgressBar();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jToggleButton1 = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Car Client");
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                onKeyPress(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                onKeyRelease(evt);
            }
        });

        lblHostname.setFont(new java.awt.Font("Ubuntu", 0, 15)); // NOI18N
        lblHostname.setText("Hostname");

        txtHostname.setText("localhost");

        jLabel3.setFont(new java.awt.Font("Ubuntu", 0, 15)); // NOI18N
        jLabel3.setText("Port");

        txtPort.setText("9090");

        btnConnect.setFont(new java.awt.Font("Lucida Grande", 0, 15)); // NOI18N
        btnConnect.setText("Connect");
        btnConnect.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConnectActionPerformed(evt);
            }
        });

        sldPitch.setMaximum(180);
        sldPitch.setOrientation(javax.swing.JSlider.VERTICAL);
        sldPitch.setValue(90);
        sldPitch.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                pitchChange(evt);
            }
        });

        pnlVideo.setBackground(new java.awt.Color(2, 190, 35));
        pnlVideo.setMinimumSize(new java.awt.Dimension(640, 480));
        pnlVideo.setPreferredSize(new java.awt.Dimension(640, 480));

        javax.swing.GroupLayout pnlVideoLayout = new javax.swing.GroupLayout(pnlVideo);
        pnlVideo.setLayout(pnlVideoLayout);
        pnlVideoLayout.setHorizontalGroup(
            pnlVideoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 640, Short.MAX_VALUE)
        );
        pnlVideoLayout.setVerticalGroup(
            pnlVideoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        sldYaw.setMaximum(180);
        sldYaw.setValue(90);
        sldYaw.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                yawChange(evt);
            }
        });

        btnLeft.setFont(new java.awt.Font("Ubuntu", 0, 15)); // NOI18N
        btnLeft.setText("L");
        btnLeft.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLeftActionPerformed(evt);
            }
        });

        btnRight.setFont(new java.awt.Font("Ubuntu", 0, 15)); // NOI18N
        btnRight.setText("R");
        btnRight.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRightActionPerformed(evt);
            }
        });

        btnBackward.setFont(new java.awt.Font("Ubuntu", 0, 15)); // NOI18N
        btnBackward.setText("B");
        btnBackward.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackwardActionPerformed(evt);
            }
        });

        btnForward.setFont(new java.awt.Font("Ubuntu", 0, 15)); // NOI18N
        btnForward.setText("F");
        btnForward.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnForwardActionPerformed(evt);
            }
        });

        btnHorn.setFont(new java.awt.Font("Ubuntu", 0, 15)); // NOI18N
        btnHorn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/timatooth/carclient/horn.png"))); // NOI18N
        btnHorn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHornActionPerformed(evt);
            }
        });

        proBattery.setValue(50);

        jLabel1.setFont(new java.awt.Font("Ubuntu", 0, 15)); // NOI18N
        jLabel1.setText("Battery");

        jLabel2.setFont(new java.awt.Font("Ubuntu", 0, 15)); // NOI18N
        jLabel2.setText("Link Strength");

        proSigStrength.setValue(80);

        jLabel4.setFont(new java.awt.Font("Ubuntu", 0, 15)); // NOI18N
        jLabel4.setText("Link Quality");

        proSigQuality.setValue(90);

        jLabel5.setFont(new java.awt.Font("Ubuntu", 0, 15)); // NOI18N
        jLabel5.setText("Latency");

        jLabel6.setText("3 ms");

        jToggleButton1.setBackground(new java.awt.Color(238, 240, 205));
        jToggleButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/timatooth/carclient/headlights.png"))); // NOI18N
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlStatsLayout = new javax.swing.GroupLayout(pnlStats);
        pnlStats.setLayout(pnlStatsLayout);
        pnlStatsLayout.setHorizontalGroup(
            pnlStatsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlStatsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlStatsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(proSigStrength, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(proBattery, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(proSigQuality, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnlStatsLayout.createSequentialGroup()
                        .addGroup(pnlStatsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(pnlStatsLayout.createSequentialGroup()
                                .addGap(39, 39, 39)
                                .addGroup(pnlStatsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnBackward)
                                    .addComponent(btnForward)))
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addGroup(pnlStatsLayout.createSequentialGroup()
                                .addComponent(btnLeft)
                                .addGap(18, 18, 18)
                                .addComponent(btnRight))
                            .addComponent(btnHorn, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                        .addComponent(jToggleButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        pnlStatsLayout.setVerticalGroup(
            pnlStatsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlStatsLayout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(proBattery, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(proSigStrength, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(proSigQuality, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(pnlStatsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jToggleButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnHorn, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnForward)
                .addGap(7, 7, 7)
                .addGroup(pnlStatsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLeft)
                    .addComponent(btnRight))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBackward)
                .addContainerGap())
        );

        tabStatsPane.addTab("Stats", pnlStats);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblHostname)
                        .addGap(18, 18, 18)
                        .addComponent(txtHostname, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPort, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnConnect, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 479, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(sldYaw, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pnlVideo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(sldPitch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tabStatsPane)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblHostname)
                    .addComponent(txtPort, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtHostname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnConnect)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sldPitch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tabStatsPane)
                    .addComponent(pnlVideo, javax.swing.GroupLayout.DEFAULT_SIZE, 547, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sldYaw, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnConnectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConnectActionPerformed
        if (connection == null) {
            try {
                connection = new CarConnection(txtHostname.getText(), Integer.parseInt(txtPort.getText()));
                connection.connect();
                writeThread = new NetWriteThread(actions, connection);
                writeThread.start();
                btnConnect.setText("Disconnect");
                txtHostname.setEnabled(false);
                txtPort.setEnabled(false);
                startVideo();
                this.requestFocus();
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Can't connect: " + ex.getMessage());
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            writeThread.setRunning(false);
            mjpegPanel.stop();
            connection.disconnect();
            connection = null;
            btnConnect.setText("Connect");
            txtHostname.setEnabled(true);
            txtPort.setEnabled(true);
        }
    }//GEN-LAST:event_btnConnectActionPerformed

    private void btnHornActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHornActionPerformed
        try {
            System.out.println("Printing horn\n");

            String horn = "H";
            connection.sendBytes(horn.getBytes());
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Couldn't send byte: " + ex.getMessage());
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.requestFocus();
    }//GEN-LAST:event_btnHornActionPerformed

    private void btnForwardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnForwardActionPerformed
        try {
            String instruction = "F";
            connection.sendBytes(instruction.getBytes());
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Couldn't send byte: " + ex.getMessage());
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnForwardActionPerformed

    private void btnBackwardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackwardActionPerformed
        try {
            String instruction = "B";
            connection.sendBytes(instruction.getBytes());
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Couldn't send byte: " + ex.getMessage());
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnBackwardActionPerformed

    private void btnLeftActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLeftActionPerformed
        try {
            String instruction = "L";
            connection.sendBytes(instruction.getBytes());
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Couldn't send byte: " + ex.getMessage());
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnLeftActionPerformed

    private void btnRightActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRightActionPerformed
        try {
            String instruction = "R";
            connection.sendBytes(instruction.getBytes());
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Couldn't send byte: " + ex.getMessage());
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnRightActionPerformed

    private void onKeyPress(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_onKeyPress
        switch (evt.getKeyChar()) {
            case 'h':
                actions.put("horn", true);
                break;
            case 'w':
                actions.put("forward", true);
                break;
            case 's':
                actions.put("backward", true);
                break;
            case 'a':
                actions.put("left", true);
                break;
            case 'd':
                actions.put("right", true);
                break;
        }
    }//GEN-LAST:event_onKeyPress

    private void onKeyRelease(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_onKeyRelease
        switch (evt.getKeyChar()) {
            case 'w':
                actions.put("forward", false);
                break;
            case 's':
                actions.put("backward", false);
                break;
            case 'a':
                actions.put("left", false);
                break;
            case 'd':
                actions.put("right", false);
                break;
            case 'h':
                actions.put("horn", false);
                break;
        }
    }//GEN-LAST:event_onKeyRelease

    private void yawChange(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_yawChange
        JSlider source = (JSlider) evt.getSource();
        if (source.getValueIsAdjusting()) {
            yawPosition = (int) source.getValue();
            try {
                String cmd = "Y";
                byte[] output = new byte[2];
                output[0] = cmd.getBytes()[0];
                output[1] = (byte) yawPosition;
                connection.sendBytes(output);
            } catch (IOException ioe) {
                System.err.println("cant send yaw change");
            }
        }
        this.requestFocus();
    }//GEN-LAST:event_yawChange

    private void pitchChange(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_pitchChange
        JSlider source = (JSlider) evt.getSource();
        if (source.getValueIsAdjusting()) {
            pitchPosition = (int) source.getValue();
            try {
                String cmd = "P";
                byte[] output = new byte[2];
                output[0] = cmd.getBytes()[0];
                output[1] = (byte) pitchPosition;
                connection.sendBytes(output);
            } catch (IOException ioe) {
                System.err.println("cant send pitch change");
            }
        }
        this.requestFocus();
    }//GEN-LAST:event_pitchChange

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jToggleButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            UIManager.setLookAndFeel(
                    UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    private void startVideo() {
        URL sourceUrl;
        try {
            int vidPort = Integer.parseInt(txtPort.getText()) + 1;
            sourceUrl = new URL("http://" + txtHostname.getText() + ":" + vidPort + "/?action=stream");
            mjpegPanel = new MjpegPanel(sourceUrl);
            pnlVideo.add(mjpegPanel);
            new Thread(mjpegPanel).start();
        } catch (MalformedURLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NumberFormatException nfe) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, nfe);
        }

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBackward;
    private javax.swing.JButton btnConnect;
    private javax.swing.JButton btnForward;
    private javax.swing.JButton btnHorn;
    private javax.swing.JButton btnLeft;
    private javax.swing.JButton btnRight;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JLabel lblHostname;
    private javax.swing.JPanel pnlStats;
    private javax.swing.JPanel pnlVideo;
    private javax.swing.JProgressBar proBattery;
    private javax.swing.JProgressBar proSigQuality;
    private javax.swing.JProgressBar proSigStrength;
    private javax.swing.JSlider sldPitch;
    private javax.swing.JSlider sldYaw;
    private javax.swing.JTabbedPane tabStatsPane;
    private javax.swing.JTextField txtHostname;
    private javax.swing.JTextField txtPort;
    // End of variables declaration//GEN-END:variables
}
