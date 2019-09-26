package inputoutput;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Date;
import java.util.GregorianCalendar;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class FileInfoFrame extends JFrame {

	// 파일 대화상자를 이용해서 파일을 선택하고 파일에 대한 정보를 출력 
	// 파일의 존재여부도 확인해보고 이름도 변경  
	
	
	JButton btnInfo;
	JButton btnCreateFile;
	JTextArea display;
	
	public FileInfoFrame() {
		
		JPanel panel =new JPanel();
		btnInfo = new JButton("파일 정보 확인"); 
		btnInfo.addActionListener(
				new ActionListener() {
			
					@Override
			public void actionPerformed(ActionEvent e) {
				
				// 파일 대화상자 만들고 출력하기 
				JFileChooser fc = new JFileChooser();
				fc.setMultiSelectionEnabled(false);
				int r = fc.showOpenDialog(null);
				
				//확인을 선택했다면 
				StringBuilder sb = new StringBuilder();
				if( r == JFileChooser.APPROVE_OPTION) {
                    File f = fc.getSelectedFile(); 
                    sb.append("마지막 수정날짜:"+
                        f.lastModified() + "\n");
                    
                    // 에폭시 타임을 Date로 변경 
                   Date d = new Date(f.lastModified());
                   sb.append("마지막 수정날짜:"+
                       d.toString()+"\n");
                    
                   //파일 크기출력 
                   //키로 바이트 단위 로 변환해서 출력 
                   sb.append("파일크기:"+f.length() + "\n");
                   long size = f.length() / 1024;
                   sb.append("파일크기:"+ size + "K\n");
                   
                   //오늘날짜를 이용해서 파일 이름 만들기 
                   //오늘날짜.log 로 만들기
                   // 현재 시간을 만들기 
                   GregorianCalendar cal = 
                		   new GregorianCalendar();
                   //Date로 변환 
                   Date today = new Date(
                		   cal.getTimeInMillis());
                   sb.append("오늘 날짜이름:" + 
                		   today.toString() + ".log");
                 
                   //파일 이름 바꾸기 
                  //변경할 파일 경로를 생성 
  /*                 File updateFile = 
                		   new File("./update.dat");
                   f.renameTo(updateFile);
  */

                   //원본파일에서 이름 3글자를 제외하고 파일이름 만들기 
                   String name = f.getName();
                   String modName = name.substring(3); 
                   File fff =new File(
                		  "./" + modName);          
                   f.renameTo(fff);
                   
                   //파일 존재 여부 확인 
                   File ff = new File("./bin");
                   if(ff.exists() == false) {
                	   sb.append("파일이 존재하지 않음\n");
                   } else {
                	   sb.append("파일이 존재함 \n");
                   }
                   
                    display.setText(sb.toString());
				} else {
					display.setText("선택한 파일이 없습니다.\n");
				}
			}
			
		});
		btnCreateFile = new JButton("파일 생성");
		btnCreateFile.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// 파일 경로를 만들기 - 현재 디렉토리의 오늘날짜.log
				 GregorianCalendar cal = 
              		   new GregorianCalendar();
                 //Date로 변환 
                 Date today = new Date(
              		   cal.getTimeInMillis());
                 
       //          URI uri = URI.create("file:///");
                 Path path = Paths.get(
                		 "./" + today.toString() + ".log");
                 //파일을 생성 
                 try {
					Files.createFile(path);
				} catch (Exception e1) {
					//예외 메세지가 null이라고 나오면 NullPointException발생 
					System.out.printf("예외:%s\n", e1.getMessage());
				}
				
			}
			
		});
		
		panel.add(btnCreateFile);
		
		panel.add(btnInfo);
		add("North", panel); 
		
		display = new JTextArea(30, 40); 
		add(display); 
		
		
		setBounds(100,100,300,300);
		pack();
		setTitle("파일정보 출력하기 ");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
}
