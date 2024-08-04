<div class="customResourceFields aboveInfo">
<dl class="customResourceFieldnative_mc_version">

<br>
<img src="https://i.imgur.com/UbPfFHT.png" alt="bg.png" class="bbCodeImage LbImage" style="">
<dt>BetonQuest Version:</dt>
<dd>2.1.3-SNAPSHOT +</dd>
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
        <i>'iaitem &lt;itemID> [amount:x]'</i>
        <ul>
            <span style="color: #8000ff"><i>e.g. 'iaitem itemsadder:ruby amount:4'</i></span><br>
            <b>Check if the player has all specified items in his inventory</b>
        </ul>
    </li>
    <li>
        <i>'iawear &lt;itemID>'</i>
        <ul>
            <span style="color: #8000ff"><i>e.g 'iawear itemsadder:ruby_helmet'</i></span><br>
            <b>Check if the player is wearing specified armor</b>
        </ul>
    </li>
    <li>
        <i>'iahand &lt;itemID> [amount:x]'</i>
        <ul>
            <b>Check if the player is holding a specified item in his hand</b>
        </ul>
    </li>
    <li>
        <i>'iablockat &lt;blockID> &lt;x;y;z;world>'</i>
        <ul>
            <span style="color: #8000ff"><i>e.g. 'iablock itemsadder:ruby_ore 40;72;3;world'</i></span><br>
            <b>Check if the block is at location</b>
        </ul>
    </li>
</ul>

<br>
<img src="https://i.imgur.com/gBvlyBh.png" alt="events.png" class="bbCodeImage LbImage" style="">
<ul>
    <li>
        <i>'iaitem &lt;ADD/REMOVE> &lt;itemID> [amount:x]'</i>
        <ul>
            <b>Adds/Removes items to/from player’s inventory</b>
        </ul>
    </li>
    <li>
        <i>'iablockat &lt;blockID> &lt;x;y;z;world>'</i>
        <ul>
            <b>Changes the block at the given position</b>
        </ul>
    </li>
    <li>
        <i>'iaplayanimation &lt;animationID>'</i>
        <ul>
            <b>Play animated title</b>
        </ul>
    </li>
</ul>

<br>
<img src="https://i.imgur.com/47WqR3y.png" alt="objectives.png" class="bbCodeImage LbImage" style="">
<ul>
    <li>
        <i>'iacraft &lt;itemID> [amount:x]'</i>
        <ul>
            <b>To complete this objective the player must craft specified item</b>
        </ul>
    </li>
    <li>
        <i>'iapickup &lt;itemID> [amount:x] [notify]'</i>
        <ul>
            <span style="color: #8000ff"><i>e.g. 'iapickup itemsadder:ruby amount:3 notify'</i></span><br>
            <b>To complete this objective you need to pick up the specified amount of items</b>
        </ul>
    </li>
    <li>
        <i>'iablockbreak &lt;blockID> [amount:x] [notify:number]'</i>
        <ul>
            <span style="color: #8000ff"><i>e.g. iablockbreak itemsadder:ruby_ore amount:5 notify:1'</i></span><br>
            <b>To complete this objective player must break specified amount of blocks</b>
        </ul>
    </li>
    <li>
        <i>'iablockplace &lt;blockID> [amount:x] [notify:number]'</i>
        <ul>
            <b>To complete this objective player must place specified amount of blocks</b>
        </ul>
    </li>
</ul>

<br>
<img src="https://i.imgur.com/eTVKRqj.png" alt="todo.png" class="bbCodeImage LbImage" style="">
<ul>
    <li><b>Create Enchant objective documentation</b></li>
    <li><b>Create Smelting objective documentation</b></li>
</ul>
