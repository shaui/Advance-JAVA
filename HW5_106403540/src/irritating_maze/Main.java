//���2B 106403540 ���ӭ� //�[������ : 1.���Ц۰ʲ��ܥk�U���}�l 2.�ܷR�ߩM������������i�H�@���H������ 3.�h�F�@��picture�b�ù��W�H�ۮɶ����ʡA�C�����s�}�l�ɡA���ʪ���V�M�t�׳��O�H�����A��������|�ϼu�C4.�I�첾�ʤ����Ϥ��ɷ|�̷ӹϤ���ܪ����e��1.���|���g���ĪG 2.�@�����~
 
package irritating_maze;

import javax.swing.JOptionPane;

public class Main {
	private static MazeFrame mf ;
	public static void main(String[] args) {
		JOptionPane.showMessageDialog
		(null, "The extra rule is following :" + "\n" 
		+ "1.The cursor will start at right-bottom corner" + "\n" 
		+ "3.If you touch the heart, you will eat it, and herat will become the wall" + "\n"
		+ "4.The wall will become heart at random at every random time,not jsut one time within the playing time" + "\n"
		+ "5.There is a Icon moving on the screen, if the picture is normal, you can on it and you'll not reduce the hp" + "\n"  
			+ "6.If the picture is changed and you touch it, you'll get the surprise!");
		mf = new MazeFrame();
	}
	
	public static void reStart() {
		IrritatingMaze.pool.shutdownNow();
		IrritatingMaze.heartPool.shutdownNow();
		MazeFrame.monicaPool.shutdownNow();
		BloodStripe.hp = 100;
		BloodStripe.setHp();
		mf.dispose();
		mf = new MazeFrame();
	}

}
