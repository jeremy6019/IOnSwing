package swing2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class TabFrame extends JFrame {

	public TabFrame() {
		//탭을 생성
		JTabbedPane tab = new JTabbedPane();
		
		JPanel panel1 = new  JPanel();	
		JButton btn = new JButton("버튼");
		//btn을 클릭하면 메세지 박스를 출력 
		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			//	JOptionPane.showMessageDialog(
			//			null,"왜 눌렀어 귀찮게!!");
			/*
				JOptionPane.showMessageDialog(
						null,"내용","제목",
						JOptionPane.ERROR_MESSAGE);
				*/
				
			/*
				int r =JOptionPane.showConfirmDialog(
						null,
						"삭제", "정말로 삭제", 
						JOptionPane.YES_NO_OPTION);
				//비교할 떄 정수값을 비교하는 것보다는 
				//Field로 비교하는 것이 좋습니다. 
				//운영체제에 따라서 정수값이 변경될 수 있습니다. 
				if(r == JOptionPane.YES_OPTION) {
					System.out.printf("예를 선택\n ");
				} else {
					System.out.printf("아니오를 선택\n ");
				}
		*/   
				
			    String input =JOptionPane.showInputDialog(
					  null,"이름을 입력하세요!!!");
				if(input == null) {
					System.out.printf("취소를 누르셨습니다.!!\n");
				} else {
					System.out.printf("%s를 입력하셨습니다.!!\n",
							input.trim().toUpperCase());
				}
				
				//javascript에서 제공되는 대화상자도 동일한 방법으로 사용 
				
			}			
		});
		panel1.add(btn);
		
		tab.add("첫번째 화면", panel1 );
		//탭을 현재 화면에 추가  
		add(tab);
		
		JPanel panel2 = new  JPanel();	
		JTextField tf = new JTextField(10);
		panel2.add(tf);
		
		tab.add("두번째 화면", panel2 );
		//탭을 현재 화면에 추가 
		add(tab);
		
		JPanel panel3 = new  JPanel();
		// 버튼 1개와 TextArea를 배치해서 버튼을 누르면 
		// 파일 대화상자를 출력하고 선택한 파일이름들을 
		// TextArea에 출력하기 
		JButton btnFile = new JButton("파일 가져오기 ");
		panel3.add(btnFile);
		
		//anonymous class에서 사용가능하도록 하기 위해서 
		//final을 붙입니다. 
		//anonymous class 에서는 자신을 포함한 메소드의 
		//지역변수를 사용할수 없습니다.  
		final JTextArea ta = new JTextArea(10, 20);
		panel3.add(ta);
		
		btnFile.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//파일 대화상자 만들기 
				JFileChooser fc = 
						new JFileChooser();
				//여러 개 선택 가능하도록 하기 				
				fc.setMultiSelectionEnabled(true);
				//파일 대화상자 출력 
				int r = fc.showOpenDialog(null);
				//확인을 눌렀을때
				if( r == JFileChooser.APPROVE_OPTION) {
					//선택한 파일 목록 가져오기 
					File[] files = fc.getSelectedFiles();
				   // String disp = "";
					
					// 문자열을 heap에 저장해서 
					// 문자열에 직접 연산을 하는 클래스의 객체 생성 
					// String은 정적영역에 문자열을 저장하고 
					// 작업을 할 때는 복사해서 수행하는 클래스 
					StringBuilder sb = new StringBuilder();
					for(File file : files) {					
						// 파일이름: file.getName(); 활용  
						
						/*	
						disp = String.format("%s%s\n",
										disp, file.getName());
						*/
						
						sb.append(file.getName());
						sb.append("\n");
					}
				//ta.setText(disp);
				  ta.setText(sb.toString());	
				} else {
					System.out.printf("선택한 파일이 없습니다.\n");
				}
				
			}
			
		});
		
		
		tab.add("파일 대화상자", panel3 );
		
		// 메뉴 표시줄 만들기 
		JMenuBar menuBar = new JMenuBar(); 
		
		JMenu menu = new JMenu("메뉴");
		
		JMenuItem item1 =new JMenuItem("대화상자 출력");
		item1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
			    JOptionPane.showMessageDialog(
			    		null, "메뉴 클릭");
			  
			}
			
		});
		// alt+m 그리고 d를 누르면 메뉴가 실행 
		// 윈도우즈에서 실행 
	    menu.setMnemonic('m');
	    item1.setMnemonic('d');
		
		menu.add(item1);
		
		menuBar.add(menu);
		
		setJMenuBar(menuBar);
		
		setBounds(100,100,300,300);
		setTitle("탭만들기 "); 
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
}
