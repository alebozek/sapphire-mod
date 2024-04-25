package net.th3m0th.sapphiremod.item;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class SapphireWand extends Item {
    public SapphireWand(Settings settings) {
        super(settings);
    }

    @Override
    public TypedActionResult<ItemStack> use (World world, PlayerEntity player, Hand hand) {
        MinecraftClient client = MinecraftClient.getInstance();
        HitResult hit = client.crosshairTarget;

        if(hit != null) {
            // gets the position where the player hitted
            BlockPos blockPos = BlockPos.ofFloored(hit.getPos());
            // this is the block that was hitted
            BlockState blockToCheck = world.getBlockState(BlockPos.ofFloored(hit.getPos()));

            // if the block type is water
            if(blockToCheck.equals(Blocks.WATER.getDefaultState())) {
                // we change the water block for air
                world.setBlockState(blockPos, Blocks.AIR.getDefaultState());
            }
        }

        return TypedActionResult.success(player.getStackInHand(hand));
    }
}
