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
import net.minecraft.world.World;

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
        assert hit != null;
        world.setBlockState(BlockPos.ofFloored(hit.getPos()), Blocks.WATER.getDefaultState());
        return TypedActionResult.success(player.getStackInHand(hand));
    }
}
