package net.th3m0th.sapphiremod.item;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.network.packet.c2s.play.PlayerInteractBlockC2SPacket;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.th3m0th.sapphiremod.SapphireMod;

public class Sapphire extends Item{
    public Sapphire(Item.Settings settings) {
        super(settings);
    }

    /**
     * Gets the position where the user hitted a block with the sapphire and then it puts a water block in that position
     * @param world
     * @param player
     * @param hand
     * @return
     */
    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand) {
        MinecraftClient client = MinecraftClient.getInstance();
        HitResult hit = client.crosshairTarget;

        if(hit != null) {
            // gets the position where the player hitted
            BlockPos waterPosition = BlockPos.ofFloored(hit.getPos());
            // this is the block that was hitted
            BlockState blockToCheck = world.getBlockState(BlockPos.ofFloored(hit.getPos()));

            // when the block is not air, water will be positioned over the block
            if(!blockToCheck.equals(Blocks.AIR.getDefaultState()) && !blockToCheck.equals(Blocks.WATER.getDefaultState())){
                waterPosition = waterPosition.up();
            }
            // we put the new water block in the position specified
            world.setBlockState(waterPosition, Blocks.WATER.getDefaultState());
        }

        return TypedActionResult.success(player.getStackInHand(hand));
    }
}
