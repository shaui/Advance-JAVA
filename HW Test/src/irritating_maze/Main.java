//���2B 106403540 ���ӭ� //�[������ : 1.���Ц۰ʲ��ܥk�U���}�l 2.�ܷR�ߩM������������i�H�@���H������ 3.�h�F�@��picture�b�ù��W�H�ۮɶ����ʡA�C�����s�}�l�ɡA���ʪ���V�M�t�׳��O�H�����A��������|�ϼu�C4.�I�첾�ʤ����Ϥ��ɷ|�̷ӹϤ���ܪ����e��1.���|���g���ĪG 2.�@�����~
 
package irritating_maze;

import javax.swing.JOptionPane;

public class Main {
	private static MazeFrame mf ;
	public static void main(String[] args) {
		
		mf = new MazeFrame();
	}
	
	public static void reStart() {
		IrritatingMaze.pool.shutdownNow();
		IrritatingMaze.heartPool.shutdownNow();
		BloodStripe.hp = 100;
		BloodStripe.setHp();
		mf.dispose();
		mf = new MazeFrame();
	}

}
