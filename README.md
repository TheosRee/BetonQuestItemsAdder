<div class="customResourceFields aboveInfo">
<dl class="customResourceFieldnative_mc_version">

<br>
<img src="https://i.imgur.com/UbPfFHT.png" alt="bg.png" class="bbCodeImage LbImage" style="">
<dt>BetonQuest Version:</dt>
<dd>2.0.0</dd>
</dl>
<dl class="customResourceFieldmc_versions">
<dt>ItemsAdder Version:</dt>
<dd>2.1.25 +</dd>
</dl>
</div>

<br>
<img src="https://i.imgur.com/zqWCGJp.png" alt="conditions.png" class="bbCodeImage LbImage" style="">
<ul>
<li>
<i>'iaitem &lt;itemID> [amount:x]'
<span style="color: #8000ff">e.g. 'iaitem itemsadder:ruby amount:4'</span></i>
<b>- Check if the player has all specified items in his inventory</b>
</li>
<li>
<i>'iawear &lt;itemID>'
<span style="color: #8000ff">e.g 'iawear itemsadder:ruby_helmet'</span></i>
<b>- Check if the player is wearing specified armor</b>
</li>
<li>
<i>'iahand &lt;itemID> [amount:x]'</i>
<b>- Check if the player is holding a specified item in his hand</b>
</li>
<li>
<i>'iablockat &lt;blockID> &lt;x;y;z;world>'
<span style="color: #8000ff">e.g. 'iablock itemsadder:ruby_ore 40;72;3;world'</span></i>
<b>- Check if the block is at location</b>
</li>
</ul>

<br>
<img src="https://i.imgur.com/gBvlyBh.png" alt="events.png" class="bbCodeImage LbImage" style="">
<ul>
<li>
<i>'iaitem &lt;ADD/REMOVE> &lt;itemID> [amount:x]'</i>
<b>- Adds/Removes items to/from player’s inventory</b>
</li>
<li>
<i>'iablockat &lt;blockID> &lt;x;y;z;world>'</i>
<b>- Changes the block at the given position</b>
</li>
<li>
<i>'iaplayanimation &lt;animationID>'</i>
<b>- Play animated title</b>
</li>
</ul>

<br>
<img src="https://i.imgur.com/47WqR3y.png" alt="objectives.png" class="bbCodeImage LbImage" style="">
<ul>
<li>
<i>'iacraft &lt;itemID> [amount:x]'</i>
<b>- To complete this objective the player must craft specified item</b>
</li>
<li>
<i>'iapickup &lt;itemID> [amount:x] [notify]'</i>
<span style="color: #5900b3">e.g. 'iapickup itemsadder:ruby 3 notify'</span>
<span style="color: #404040"><b>- To complete this objective you need to pick up the specified amount of items</b></span>
</li>
<li>
<span style="color: #000000">'iablockbreak &lt;blockID> [amount:x] [notify:number]'</span>
<span style="color: #5900b3">e.g. 'iablockbreak itemsadder:ruby_ore 5 notify:1'</span>
<span style="color: #404040"><b>- To complete this objective player must break specified amount of blocks</b></span>
</li>
<li>
<span style="color: #404040">'iablockplace &lt;blockID> [amount:x] [notify:number]'
<b>- To complete this objective player must place specified amount of blocks</b></span>
</li>
</ul>

<br>
<img src="https://i.imgur.com/eTVKRqj.png" alt="todo.png" class="bbCodeImage LbImage" style="">
<ul>
<li><b>Create Enchant objective</b></li>
<li><b>Create Smelting objective</b></li>
<li><b>Fix Formatting of README in Objectives</b></li>
</ul>
