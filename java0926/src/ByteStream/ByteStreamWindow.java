package ByteStream;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.sql.Date;
import java.util.GregorianCalendar;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class ByteStreamWindow extends JFrame {
    
	//메뉴 역할을 수행할 버튼 
	JButton btnInput, btnOutput, bufferInput, bufferOutput;
	//입력과 출력을 담당할 TextArea 
	JTextArea display;
	
	public ByteStreamWindow() {
		JPanel btnPanel = new JPanel();
		
		btnInput = new JButton("바이트 입력");
		btnOutput = new JButton("바이트 출력");
		
		bufferInput = new JButton("버퍼 입력");
		bufferOutput = new JButton("버퍼 출력");
				
		
		ActionListener handler = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// 1) 파일이름 만들 부분 
				//오늘 날짜를 문자열로 만들기 
				GregorianCalendar cal =
						new GregorianCalendar();
				Date today = new Date(cal.getTimeInMillis());
			    //오늘날짜.log라는 파일 이름을 생성 
				String filePath =String.format(
						"./%s.log", today.toString()); 
		// 1)끝 
				
				if(e.getSource() == btnInput) {
					try(FileInputStream fis = 
							new FileInputStream(filePath)){
						
						// 파일의 전체 크기 확인 
						long len = fis.available();
						// 파일의 내용을 한 번에 읽기 
						// 바이트 스트림으로 문자열을 읽을 때는 한 번에 읽기   
						byte[] b = new byte[(int)len];
						//내용 읽기
						fis.read(b);
	                    // 읽은 내용을 문자열로 만들기 
						// MS949와  CP949 같은 것 파일의 내용이 깨져서 보임 
						String msg = new String(b, "UTF-8");
						// 내용 출력 
						String result = String.format(
								"파일 크기: %d\n파일 내용: %s", len, msg);
						display.setText(result);
					
					} catch (Exception e1) {
						display.setText("읽을 파일이 존재하지 않습니다!!");
					}
					        
			    } else if(e.getSource() == btnOutput) {
			    	try(FileOutputStream fos = 
							new FileOutputStream(filePath, true)){	
						// 기록할 내용 만들기 
						String txt = display.getText();
						byte[] b = txt.getBytes("UTF-8");
						// 버퍼에 기록 
						fos.write(b);
						//버퍼의 내용을 기록 
						fos.flush();
						display.setText("저장 성공!!!");
					} catch (Exception e1) {
						display.setText("파일 경로를 확인하세요!!!");				
					}
							    	
			    }else if(e.getSource() == bufferInput) {
			    	try(BufferedInputStream bis =
			    			new BufferedInputStream(
			    					new FileInputStream(filePath))){
			    		int len = bis.available(); 
			    		byte[] b =new byte[len]; 
			    		bis.read(b);
			    		String str = new String(b); 
			    		display.setText(str);
			    		
			    	} catch(Exception e1) {
			    		display.setText("읽을 파일이 없습니다.");
			    	}
			    	
			    } else if(e.getSource() == bufferOutput) {
			    	try(PrintStream ps =
			    			new PrintStream(
			    					new FileOutputStream(filePath))){
			    		String msg = display.getText();
			    //		byte[] b = msg.getBytes();
			    //		ps.write(b);
			    		ps.print(msg);
			    		ps.flush();
			    		
			    	} catch(Exception e1) {
			    		display.setText("파일 경로를 확인하세요!!");
			    	}
			    	
			    }
				
			}
			
		};
		
		//	2개의 버튼의 액션 이벤트를 handler하나로 처리 - 이벤트 라우팅 
		//유사한 역할을 하는 객체가 여러 개 있을때 
		//객체별로 이벤트 처리를 하게되면 코드가 중복되서 
		//유지보수를 어렵게 할 수 있습니다. 
		btnInput.addActionListener(handler);
		btnOutput.addActionListener(handler);
		btnPanel.add(btnInput);
		btnPanel.add(btnOutput);
				
		bufferInput.addActionListener(handler);
		bufferOutput.addActionListener(handler);		
		btnPanel.add(bufferInput);
		btnPanel.add(bufferOutput); 
		
		add("North", btnPanel); 
		
		display = new JTextArea(30, 40);
		add(display);
		

		setBounds(100,100,300,300);
		pack();
		setTitle("바이트 스트림 사용");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
}
