<script>
  import UmschG from "./UmschG.svelte";
  let text = "";

  if (sessionStorage.getItem("displayText") != null) {
    text = sessionStorage.getItem("displayText");
  }

  function getText() {

    setSessionStorage();
  }

  function setSessionStorage() {
    sessionStorage.setItem("displayText", text);
    console.log(window.sessionStorage.getItem("displayText"));
  }
</script>

<div class="textField">
  <h1>Displaytext</h1>
  <p>Text darf nicht mehr als 160 Zeichen beinhalten.</p>
  <textarea
    class="eingabe"
    bind:value={text}
    on:input={getText}
    maxlength="160"
  />
  <p>Zeichen: <span id="demo2">{text.length}</span></p>

  <UmschG />
</div>

<style>
  :global(body) {
    background-color: #2e2e2e;
    padding: 0;
    margin: 0;
    overflow-x: hidden;
    color: white;
    font-family: "Courier New", Courier, monospace;
  }
  p {
    font-weight: bold;
    font-size: 15px;
    color: rgb(150, 150, 150);
  }
  .textField {
    width: 60%;
    padding-left: 10px;
    display: flex;
    justify-content: center;
    align-items: center;
    flex-direction: column;
  }
</style>
