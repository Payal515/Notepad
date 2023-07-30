import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.io.*;
import java.util.*;
class Notepad implements ActionListener
    {
        JFrame f;
        JTextArea ta;
        JMenuBar mb;
        JMenu file,edit,format,help;
        JMenuItem newi,openi,savei,printi;
        JMenuItem cuti,copyi,pastei,selectalli;
        JMenuItem bg,fg;
        JTextField text = new JTextField();
        Notepad(){

            
            
        f=new JFrame();

        ta=new JTextArea();
        mb=new JMenuBar();
        file=new JMenu("File");
        edit=new JMenu("Edit");
        format=new JMenu("Format");
        help=new JMenu("Help");
        //filemenu
        newi=new JMenuItem("New");
        openi=new JMenuItem("Open");
        printi=new JMenuItem("print");
        savei=new JMenuItem("Save");
        //editmenu
        cuti=new JMenuItem("Cut");
        copyi=new JMenuItem("Copy");
        pastei=new JMenuItem("Paste");
        selectalli=new JMenuItem("Select All");



       //format menu
        bg=new JMenuItem("Set Background");
        fg=new JMenuItem("Set Foreground");
        
        file.add(newi);
        file.add(openi);
        file.add(printi);
        file.add(savei);

        edit.add(cuti);
        edit.add(copyi);
        edit.add(pastei);
        edit.add(selectalli);

        format.add(bg);
        format.add(fg);

        cuti.addActionListener(this);
        copyi.addActionListener(this);
        pastei.addActionListener(this);
        selectalli.addActionListener(this);

        bg.addActionListener(this);
        fg.addActionListener(this);

        newi.addActionListener(this);
        openi.addActionListener(this);
        printi.addActionListener(this);
        savei.addActionListener(this);


        mb.add(file);
        mb.add(edit);
        mb.add(format);
        mb.add(help);
        mb.setBounds(4,5,996,40);
        ta.setBounds(4,40,996,996);
        f.add(mb);
        f.add(ta);
        f.setLayout(null);
        f.setTitle("My Notepad");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.getContentPane().setBackground(Color.WHITE);
        f.setSize(1000,1000);
        f.setVisible(true);
    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==cuti){
            ta.cut();

        }
        else if(e.getSource()==copyi){
            ta.copy();

        }
       else if(e.getSource()==pastei){
        ta.paste();

        }
        else if(e.getSource()==selectalli){
            ta.selectAll();

        }
        else if(e.getSource()==bg){
            JColorChooser color_box=new JColorChooser();
            Color c=color_box.showDialog(f,"Select a Color",Color.WHITE);


            ta.setBackground(c);

        }
        else if(e.getSource()==fg){

            JColorChooser color_box=new JColorChooser();
            Color c=color_box.showDialog(f,"Select a Color",Color.WHITE);


            ta.setForeground(c);

        }
        else if(e.getSource()==newi){
            ta.setText("");
            ta.setBackground(Color.WHITE);

        }
        else if(e.getSource()==openi){
            JFileChooser fileChooser=new JFileChooser();
            int option=fileChooser.showOpenDialog(f);
            File f=fileChooser.getSelectedFile();
            try{
                Scanner sc=new Scanner(f);
                while(sc.hasNextLine()){
                    ta.append("\n"+sc.nextLine());
                }

            } 
            catch(Exception ex){ 
            }
        }

        else if(e.getSource()==printi){
            JTextArea toPrint=new JTextArea("Text here");
            try{
                boolean done=toPrint.print();
                JOptionPane.showMessageDialog(new JFrame(),"Printing "+(done?"Completed":"canceled"));
            }
            catch(Exception ex){
    
            }
    
        }
        else if(e.getSource()==savei){
            JFileChooser fileChooser=new JFileChooser();
                fileChooser.setDialogTitle("file to save");
                int option=fileChooser.showSaveDialog(f);
                if(option==JFileChooser.APPROVE_OPTION){
                    try{
                        File f=fileChooser.getSelectedFile();
                        String text=ta.getText();
                        FileWriter myw=new FileWriter(f);
                        myw.write(text);
                        myw.close();
                        System.out.println("Succesful");
                    }
                    catch(Exception ex){  
                }

            }} 
    }
    public static void main(String args[]){
        Notepad np=new Notepad();
}
}