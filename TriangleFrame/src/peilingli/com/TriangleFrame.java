package peilingli.com;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class TriangleFrame {

	private JFrame frame;
	private JTextField textFieldA;
	private JTextField textFieldB;
	private JTextField textFieldC;
	private JLabel resultLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TriangleFrame window = new TriangleFrame();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TriangleFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 374, 170);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("请输入三角形的三个边长:");
		label.setBounds(31, 41, 178, 15);
		frame.getContentPane().add(label);
		
		textFieldA = new JTextField();
		textFieldA.setToolTipText("范围[1, 100]");
		textFieldA.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				int keyChar = e.getKeyCode();			
				if(KeyEvent.VK_BACK_SPACE == keyChar || keyChar >= KeyEvent.VK_0 && keyChar <= KeyEvent.VK_9){
					getResult();
				}else{
					e.consume(); //关键，屏蔽掉非法输入
				}

			}
		});
		textFieldA.setText("10");
		textFieldA.setBounds(26, 68, 81, 19);
		frame.getContentPane().add(textFieldA);
		textFieldA.setColumns(10);
		
		textFieldB = new JTextField();
		textFieldB.setToolTipText("范围[1, 100]");
		textFieldB.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				int keyChar = e.getKeyCode();			
				if(KeyEvent.VK_BACK_SPACE == keyChar || keyChar >= KeyEvent.VK_0 && keyChar <= KeyEvent.VK_9){
					getResult();
				}else{
					e.consume(); //关键，屏蔽掉非法输入
				}

			}
		});
		textFieldB.setText("10");
		textFieldB.setColumns(10);
		textFieldB.setBounds(138, 68, 81, 19);
		frame.getContentPane().add(textFieldB);
		
		textFieldC = new JTextField();
		textFieldC.setToolTipText("范围[1, 100]");
		textFieldC.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				int keyChar = e.getKeyCode();			
				if(KeyEvent.VK_BACK_SPACE == keyChar || keyChar >= KeyEvent.VK_0 && keyChar <= KeyEvent.VK_9){
					getResult();
				}else{
					e.consume(); //关键，屏蔽掉非法输入
				}

			}
		});
		textFieldC.setText("10");
		textFieldC.setColumns(10);
		textFieldC.setBounds(253, 68, 81, 19);
		frame.getContentPane().add(textFieldC);
		
		resultLabel = new JLabel("等边三角形");
		resultLabel.setBounds(138, 99, 196, 15);
		frame.getContentPane().add(resultLabel);
	}
	
	private void getResult() {
		if (textFieldA.getText().isEmpty() || 
			textFieldB.getText().isEmpty() ||
			textFieldC.getText().isEmpty()) {
			resultLabel.setText("");
		} else {
			Triangle triangle = new Triangle(Integer.parseInt(textFieldA.getText()), 
					Integer.parseInt(textFieldB.getText()), Integer.parseInt(textFieldC.getText()));
			String ret = triangle.CheckTriangle();
			resultLabel.setText(ret);
		}
	}

}
