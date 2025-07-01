package chat;

import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;

public class ChatExample implements Runnable{
    private JTextPane chatPane;
    private StyledDocument doc;

    public ChatExample(String msg) {
        JFrame frame = new JFrame("Chat UI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 500);

        chatPane = new JTextPane();
        chatPane.setEditable(false);
        doc = chatPane.getStyledDocument();

        JScrollPane scrollPane = new JScrollPane(chatPane);
        frame.add(scrollPane, BorderLayout.CENTER);

        frame.setVisible(true);

        // 테스트 메시지
        appendMessage("안녕하세요!", false); // 상대방
        appendMessage("안녕하세요!", false); // 상대방
        appendMessage("안녕하세요! 반갑습니다.", true); // 나
        appendMessage("안녕하세요! 반갑습니다.", true); // 나
        appendMessage("안녕하세요! 반갑습니다.", true); // 나
    }

    public void appendMessage(String message, boolean isMine) {
        // 스타일 생성
        SimpleAttributeSet attrSet = new SimpleAttributeSet();
        StyleConstants.setAlignment(attrSet, isMine ? StyleConstants.ALIGN_RIGHT : StyleConstants.ALIGN_LEFT);
        StyleConstants.setForeground(attrSet, isMine ? Color.BLUE : Color.BLACK);
        StyleConstants.setFontSize(attrSet, 14);
        StyleConstants.setSpaceAbove(attrSet, 4);
        StyleConstants.setSpaceBelow(attrSet, 4);

        try {
            // 새 단락 삽입
            int length = doc.getLength();
            doc.insertString(length, message + "\n", attrSet);
            doc.setParagraphAttributes(length, message.length(), attrSet, false);
        } catch (BadLocationException e) {
            e.printStackTrace();
        }
    }
    
    public void run() {
    	
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new ChatExample(null));
    }
}
