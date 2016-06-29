package thebetweenlands.common.item.misc;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import thebetweenlands.common.item.IGenericItem;
import thebetweenlands.common.registries.ItemRegistry;

public class ItemMisc extends Item implements ItemRegistry.ISubItemsItem {
	public ItemMisc() {
		setMaxDamage(0);
		setHasSubtypes(true);
	}

	@Override
	@SideOnly(Side.CLIENT)
	@SuppressWarnings({"unchecked", "rawtypes"})
	public void getSubItems(Item item, CreativeTabs tab, List list) {
		for (EnumItemMisc type : EnumItemMisc.values())
			list.add(type.create(1));
	}

	@Override
	public String getUnlocalizedName(ItemStack stack) {
		try {
			return "item.thebetweenlands." + IGenericItem.getFromStack(EnumItemMisc.class, stack).getUnlocalizedName();
		} catch (Exception e) {
			return "item.thebetweenlands.unknownGeneric";
		}
	}

	@Override
	public List<String> getModels() {
		List<String> models = new ArrayList<String>();
		for (EnumItemMisc type : EnumItemMisc.values())
			models.add(type.getUnlocalizedName());
		return models;
	}

	public enum EnumItemMisc implements IGenericItem {
		BLOOD_SNAIL_SHELL(0),
		MIRE_SNAIL_SHELL(1),
		COMPOST(2),
		DRAGONFLY_WING(3),
		LURKER_SKIN(4),
		SWAMP_REED(5),
		DRIED_SWAMP_REED(6),
		SWAMP_REED_ROPE(7),
		TANGLED_ROOT(8),
		PLANT_TONIC(9),
		MUD_BRICK(10),
		SYRMORITE_INGOT(11),
		OCTINE_INGOT(12),
		ROTTEN_BARK(13),
		SLIMY_BONE(14),
		SLUDGE_BALL(15),
		SNAPPER_ROOT(16),
		STALKER_EYE(17),
		SULFUR(18),
		VALONITE_SHARD(19),
		WEEDWOOD_STICK(20),
		ANGLER_TOOTH(21),
		WEEDWOOD_BOWL(22),
		RUBBER_BALL(23),
		TAR_BEAST_HEART(24),
		TAR_BEAST_HEART_ANIMATED(25),
		TAR_DRIP(26),
		LIMESTONE_FLUX(27),
		SWAMP_KELP(28),
		INANIMATE_TARMINION(29),
		POISON_GLAND(30),
		ASPECTRUS_FRUIT(31),
		PARCHMENT(32),
		SHOCKWAVE_SWORD_1(33),
		SHOCKWAVE_SWORD_2(34),
		SHOCKWAVE_SWORD_3(35),
		SHOCKWAVE_SWORD_4(36),
		PYRAD_FLAME(37),
		AMULET_SOCKET(38),
		SCABYST(39);

		private final int id;
		private final String unlocalizedName;

		EnumItemMisc(int id) {
			this.id = id;
			this.unlocalizedName = this.name().toLowerCase(Locale.ENGLISH);
		}

		@Override
		public String getUnlocalizedName() {
			return this.unlocalizedName;
		}

		@Override
		public int getID() {
			return this.id;
		}

		@Override
		public Item getItem() {
			return ItemRegistry.ITEMS_MISC;
		}
	}
}
