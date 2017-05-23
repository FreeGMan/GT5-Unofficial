package gregtech.api.util;

import gregtech.api.interfaces.tileentity.IGregTechTileEntity;
import net.minecraft.block.Block;

public abstract class GT_MultiblockStructureValidator {
    public GT_MultiblockStructureValidator(String[][] structure) {
        this.structure = structure;
        for (int i = 0; i < structure.length; i++) {
            for (int j = 0; j < structure[i].length; j++) {
                int index = structure[i][j].indexOf('c');
                if (index == -1) {
                    index = structure[i][j].indexOf('C');
                }
                if (index != -1) {
                    cX = index;
                    cZ = j;
                    cY = i;
                    return;
                }
            }
        }
    }

    String[][] structure;
    int cX, cY, cZ;

    public abstract boolean validateBlock(char pattern, Block block, int meta, IGregTechTileEntity tileEntity);

    public boolean validateStructure(IGregTechTileEntity controller, int... rotations) {
        int[] vec = new int[3];
        for (int rotation : rotations) {
            for (int y = 0; y < structure.length; y++) {
                for (int z = 0; z < structure[y].length; z++) {
                    for (int x = 0; x < structure[y][z].length(); x++) {
                        char ch = structure[y][z].charAt(x);
                        vec[0] = x;
                        vec[1] = y;
                        vec[2] = z;
                        transformVec(vec, rotation);
                        if (!validateBlock(ch, controller.getBlockOffset(vec[0], vec[1], vec[2]), controller.getMetaIDOffset(vec[0], vec[1], vec[2]), controller.getIGregTechTileEntityOffset(vec[0], vec[1], vec[2]))) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

    private void transformVec(int[] vec, int rotation) {
        vec[0] -= cX;
        vec[1] -= cY;
        vec[2] -= cZ;
        switch (rotation) {
            case 4:
                vec[0] *= -1;
                vec[2] *= -1;
                //break is absent here intentionally
            case 5:
                int q = vec[0];
                vec[0] = vec[2];
                vec[2] = q;
                break;
            case 2:
                vec[0] *= -1;
                vec[2] *= -1;
                break;
            case 3:
                break;
        }
    }


}
