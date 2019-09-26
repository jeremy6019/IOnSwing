package chracterStream;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class CharacterStreamWindow extends JFrame {
    
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//파일에 읽기와 쓰기를 수행할 버튼 
	JButton btnWrite, btnRead, bufRead, bufWrite;
	//입력 내용과 출력을 담당할 텍스트 영역 
	JTextArea display;
	
	public CharacterStreamWindow() {
		JPanel panel = new JPanel();
		//버튼을 상단에 배치 
		btnWrite = new JButton("문자스트림 기록");
		btnRead = new JButton("문자 스트림 읽기");
		bufWrite = new JButton("버퍼 문자 스트림 쓰기");
		bufRead = new JButton("버퍼 문자 스트림 읽기");
		
		panel.add(btnWrite);
		panel.add(btnRead);
		panel.add(bufWrite);
		panel.add(bufRead);
		add("North", panel);
		
		//출력 영역을 중앙에 배치 
		display = new JTextArea(30, 20);
		add(display);
	
		//현재 클래스의 객체를 EventHandler에게 넘겨서 
		//객체를 생성 
		EventHandler handler =
				new EventHandler(this);
		// 버튼들의 클릭이벤트 처리를 handler에게 위임함 
		btnWrite.addActionListener(handler);
		btnRead.addActionListener(handler);
		
		bufWrite.addActionListener(handler);
		bufRead.addActionListener(handler);
		
		setBounds(150,150,400,400);
		pack();
		setTitle("문자 스트림 & 버퍼 스트림 사용");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
}
