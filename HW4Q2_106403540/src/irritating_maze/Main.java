//���2B 106403540 ���ӭ� //�[������ : 1.�����j�p���׫��վ�A�Ϥ����|����Y�� 2.����|��ܷǽT���Ѿl��q 3.����R�߷|�Y�����æ^�_�Q�I�ͩR�� 4.���а_�l��m�]�w��k�U��
 
package irritating_maze;

public class Main {
	private static MazeFrame mf ;
	public static void main(String[] args) {
		mf = new MazeFrame();
	}
	
	public static void reStart() {
		IrritatingMaze.pool.shutdownNow();
		IrritatingMaze.heartPool.shutdownNow();
		mf.dispose();
		mf = new MazeFrame();
	}

}
