<div class="customResourceFields aboveInfo">
<dl class="customResourceFieldnative_mc_version">

<br>
<img src="https://i.imgur.com/UbPfFHT.png" alt="bg.png" class="bbCodeImage LbImage" style="">
<dt>BetonQuest Version:</dt>
<dd>3.0.0-DEV-273</dd>
</dl>
<dl class="customResourceFieldmc_versions">
<dt>ItemsAdder Version:</dt>
<dd>2.1.25 +</dd>
</dl>
</div>

Now uses BQ conditions and events for most stuff!

Search for ["Item"](https://betonquest.org/DEV/Documentation/Scripting/About-Scripting/?q=item)
on the BetonQuest documentation to see how you can use them.

<b>Example</b>:
<div>
items:
<br>&nbsp&nbsp;
ruby: ia itemsadder:ruby

conditions:
<br>&nbsp;&nbsp;
hasRuby: item ruby

events:
<br>&nbsp;&nbsp;
giveRuby: give ruby
</div>

<br>
<h2>This plugin also adds the following to BetonQuest:</h2>
<br>

<img src="https://i.imgur.com/zqWCGJp.png" alt="conditions.png" class="bbCodeImage LbImage" style="">
<ul>
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
