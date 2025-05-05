package mypack;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class photoUploader {
    
    JFrame jf = new JFrame("Upload Student Photo");
    JFrame retreiveFrame = new JFrame("Retrieve Photo");
    private JLabel photoLabel = new JLabel();
    JLabel l1 = new JLabel("Student ID: ");
    JTextField t1 = new JTextField();
    private JFileChooser fileChooser = new JFileChooser();
    private File selectedFile;
    private JButton uploadBTN = new JButton("Upload Photo");
    private JButton retrieveBTN = new JButton("Retrieve Photo");
    private JButton continueBTN = new JButton("Continue");
    private JButton exitBTN = new JButton("Exit");
    private JButton clearBTN = new JButton("Clear Photo");
    
    static Connection con;
    String path;
    
    void showframe() {
        jf.setLayout(null);
        jf.setSize(700, 500);
        
        l1.setSize(100, 20);
        l1.setLocation(20, 20);
        jf.add(l1);
        
        t1.setSize(90, 20);
        t1.setLocation(90, 21);
        t1.setText("21UCS1001");
        t1.setEditable(false);
        jf.add(t1);
        
        photoLabel.setSize(300, 400);
        photoLabel.setLocation(60, 50);
        jf.add(photoLabel);
        
        uploadBTN.setSize(150, 25);
        uploadBTN.setLocation(500, 50);
        jf.add(uploadBTN);
        
        retrieveBTN.setSize(150, 25);
        retrieveBTN.setLocation(500, 100);
        jf.add(retrieveBTN);
        
        clearBTN.setSize(150, 25);
        clearBTN.setLocation(500, 150);
        jf.add(clearBTN);
        
        exitBTN.setSize(150, 25);
        exitBTN.setLocation(500, 200);
        jf.add(exitBTN);
        
        continueBTN.setSize(100, 25);
        continueBTN.setLocation(550, 400);
        jf.add(continueBTN);
        
        uploadPhotoPath();
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setLocationRelativeTo(null);
        jf.setVisible(true);
    }
    
    private void uploadPhotoPath() {
        String url = "jdbc:mysql://localhost:3306/javafullstack830";
        String user = "root";
        String pw = "";
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, user, pw);
        } catch (ClassNotFoundException classEXP) {
            classEXP.printStackTrace();
        } catch (SQLException sql) {
            sql.printStackTrace();
        }
        
        uploadBTN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int returnval = fileChooser.showOpenDialog(jf);
                if (returnval == JFileChooser.APPROVE_OPTION) {
                    selectedFile = fileChooser.getSelectedFile();
                    ImageIcon imageic = new ImageIcon(selectedFile.getAbsolutePath());
                    photoLabel.setIcon(imageic);
                }
            }
        });
        
        continueBTN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Path targetDir = Paths.get("Student_Photos");
                if (!Files.exists(targetDir)) {
                    try {
                        Files.createDirectories(targetDir);
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                }
                
                int res = JOptionPane.showConfirmDialog(jf, "Are you sure you want to upload your image?", "Photo Uploader", JOptionPane.YES_NO_OPTION);
                if (res == JOptionPane.YES_OPTION) {
                    try {
                        Path targetPath = targetDir.resolve(selectedFile.getName());
                        Files.copy(selectedFile.toPath(), targetPath);
                        path = targetPath.toString();
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                    
                    try {
                        String q = "INSERT INTO sphotos (stuid, picpath) VALUES (?, ?)";
                        PreparedStatement ps = con.prepareStatement(q);
                        ps.setString(1, t1.getText());
                        ps.setString(2, path);
                        ps.execute();
                        JOptionPane.showMessageDialog(jf, "Insertion Successful!", "Photo Uploader", JOptionPane.INFORMATION_MESSAGE);
                    } catch (SQLException sql1) {
                        sql1.printStackTrace();
                    }
                }
            }
        });
        
        retrieveBTN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JTextField idtf = new JTextField();
                JTextField dobtf = new JTextField();
                JLabel idlabel = new JLabel("Enter a Student ID: ");
                JLabel doblabel = new JLabel("Enter a Student D.O.B: ");
                JButton fetchBtn = new JButton("Fetch My Photo");
                
                idlabel.setSize(150, 20);
                idlabel.setLocation(30, 50);
                retreiveFrame.add(idlabel);
                
                idtf.setSize(100, 20);
                idtf.setLocation(200, 50);
                retreiveFrame.add(idtf);
                
                doblabel.setSize(150, 20);
                doblabel.setLocation(30, 90);
                retreiveFrame.add(doblabel);
                
                dobtf.setSize(100, 20);
                dobtf.setLocation(200, 90);
                retreiveFrame.add(dobtf);
                
                fetchBtn.setSize(150, 25);
                fetchBtn.setLocation(200, 200);
                retreiveFrame.add(fetchBtn);
                
                fetchBtn.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String id = idtf.getText();
                        try {
                            String q = "SELECT picpath FROM sphotos WHERE stuid = ?";
                            PreparedStatement ps = con.prepareStatement(q);
                            ps.setString(1, id);
                            ResultSet rs = ps.executeQuery();
                            
                            if (rs.next()) {
                                ImageIcon imageic = new ImageIcon(rs.getString("picpath"));
                                retreiveFrame.setVisible(false);
                                photoLabel.setIcon(imageic);
                            } else {
                                JOptionPane.showMessageDialog(retreiveFrame, "Data Not Found!", "Error", JOptionPane.ERROR_MESSAGE);
                            }
                        } catch (SQLException e1) {
                            e1.printStackTrace();
                        }
                    }
                });
                
                retreiveFrame.setLayout(null);
                retreiveFrame.setSize(400, 300);
                retreiveFrame.setLocationRelativeTo(jf);
                retreiveFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                retreiveFrame.setVisible(true);
            }
        });
        
        clearBTN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                photoLabel.setIcon(null);
            }
        });
        
        exitBTN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int res = JOptionPane.showConfirmDialog(jf, "Are you sure you want to exit?", "Exit", JOptionPane.YES_NO_OPTION);
                if (res == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            }
        });
    }
    
    photoUploader() {
        showframe();
    }
    
    public static void main(String args[]) {
        new photoUploader();
    }
}
