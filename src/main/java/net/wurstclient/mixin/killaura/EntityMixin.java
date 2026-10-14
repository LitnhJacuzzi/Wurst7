/*
 * Copyright (c) 2014-2026 Wurst-Imperium and contributors.
 *
 * This source code is subject to the terms of the GNU General Public
 * License, version 3. If a copy of the GPL was not distributed with this
 * file, You can obtain one at: https://www.gnu.org/licenses/gpl-3.0.txt
 */
package net.wurstclient.mixin.killaura;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.minecraft.world.entity.Entity;
import net.wurstclient.WurstClient;

@Mixin(Entity.class)
public abstract class EntityMixin
{
	@Inject(method = "setRemoved", at = @At("TAIL"))
	private void onRemoval(CallbackInfo ci)
	{
		WurstClient.INSTANCE.getHax().killauraHack
			.onEntityRemoval((Entity)(Object)this);
	}
}
