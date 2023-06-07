<script>
  let ssid = "";
  let yes = false;
  let SSIDbestehend = "Drehteller1";
  let newWLANpasswort = "";
  let newWLAN = "";
  let passwortBestehend = "";

  if(sessionStorage.getItem("wlanSSID") != null) {
    newWLAN = sessionStorage.getItem("wlanSSID");
  }
  if(sessionStorage.getItem("wlanPass") != null) {
    newWLANpasswort = sessionStorage.getItem("wlanPass");
  }
  if(sessionStorage.getItem("hotspotSSID") != null) {
    SSIDbestehend = sessionStorage.getItem("hotspotSSID");
  }
  if(sessionStorage.getItem("hotspotPass") != null) {
    passwortBestehend = sessionStorage.getItem("hotspotPass");
  }


  function scream() {
    console.log(ssid);
    console.log(SSIDbestehend);
  }

  async function connectToWLAN() {
    await fetch("/connect-wlan", {
      method: "POST",
      headers: {"Content-Type": "application/json"},
      body: JSON.stringify({}),
    });
  }

  async function activateHotspot() {
    await fetch("/connect-hotspot", {
      method: "POST",
      headers: {"Content-Type": "application/json"},
      body: JSON.stringify({}),
    });
  }

  async function connectToNewWLAN() {
    if(sessionStorage.getItem("wlanSSID") != null && sessionStorage.getItem("wlanPass") != null) {
      const data = {
        wlanSSID: sessionStorage.getItem("wlanSSID"),
        wlanPass: sessionStorage.getItem("wlanPass")
      };

      await fetch("/change-wlan", {
        method: "POST",
        headers: {"Content-Type": "application/json"},
        body: JSON.stringify(data),
      });
    }
  }

  async function changeHotspot() {
    if(sessionStorage.getItem("hotspotSSID") != null && sessionStorage.getItem("hotspotPass") != null) {
      const data = {
        hotspotSSID: sessionStorage.getItem("hotspotSSID"),
        hotspotPass: sessionStorage.getItem("hotspotPass")
      };

      await fetch("/change-hotspot", {
        method: "POST",
        headers: {"Content-Type": "application/json"},
        body: JSON.stringify(data),
      });
    }
  }

  function setSessionWlanSSID() {
    sessionStorage.setItem("wlanSSID", newWLAN);
    console.log(window.sessionStorage.getItem("wlanSSID"));
  }

  function setSessionWlanPass() {
    sessionStorage.setItem("wlanPass", newWLANpasswort);
    console.log(window.sessionStorage.getItem("newWLANpasswort"));
  }

  function setSessionHotspotSSID() {
    sessionStorage.setItem("hotspotSSID", SSIDbestehend);
    console.log(window.sessionStorage.getItem("hotspotSSID"));
  }

  function setSessionHotspotPass() {
    sessionStorage.setItem("hotspotPass", passwortBestehend);
    console.log(window.sessionStorage.getItem("hotspotPass"));
  }

</script>

<div class="switchContainer">
  <div class="container">
    <div class="container1" id="hotspotCon">
      <div class="buttons">
        <button class="btnSubmit" on:click={connectToWLAN}
          >Mit WLAN verbinden</button
        >
        <button class="btnSubmit" on:click={activateHotspot}
          >Hotspot aktivieren</button
        >
      </div>

      <h1>Neues WLAN hinzufügen</h1>
      <p>SSID</p>
      <input
        class="eingabe"
        type="string"
        bind:value={newWLAN}
        on:input={setSessionWlanSSID}
      />
      <p>Passwort</p>
      <input
        class="eingabe"
        type="string"
        bind:value={newWLANpasswort}
        on:input={setSessionWlanPass}
      />
      <button class="btnSubmit" on:click={connectToNewWLAN}>Verbinden</button>

      <h1>Eigenen Hotspot ändern</h1>
      <!--        <button class="btnSubmit" disabled={!yes} on:click={connectToWLAN()}>Verbinden</button>-->
      <p>SSID</p>
      <!--        <input class="eingabe" type="string" id="wlanSSID" disabled={!yes} on:input={scream} bind:value={SSIDbestehend}>-->
      <input
        class="eingabe"
        type="string"
        id="wlanSSID"
        bind:value={SSIDbestehend}
        on:input={setSessionHotspotSSID}
      />
      <p>Passwort</p>
      <!--        <input class="eingabe" type="string" id="wlanPasswort" disabled={!yes} on:input={scream} bind:value={passwort}>-->
      <input
        class="eingabe"
        type="string"
        id="wlanPasswort"
        bind:value={passwortBestehend}
        on:input={setSessionHotspotPass}
      />
      <button class="btnSubmit" on:click={changeHotspot}>Ändern</button>
    </div>
  </div>
</div>

<style>
  .buttons {
    display: flex;
    flex-direction: row;
  }

  #connect {
    width: 70%;
  }

  #connect:hover {
    background-color: #1f1f1f;
  }

  #connect:disabled {
    background-color: #6b6b6b;
    color: #c1c1c1;
  }

  #connect:focus {
    outline: none;
    background-color: #39b3ff;
  }

  .switchContainer {
    display: flex;
    justify-content: center;
    flex-direction: column;
    align-items: center;
  }

  .container1 {
    display: flex;
    justify-content: center;
    flex-direction: column;
    align-items: center;
    padding-bottom: 3em;
  }

  .container {
    padding-bottom: 3em;
  }

  .switch {
    margin-top: 1em;
    position: relative;
    display: inline-flex;
    width: 60px;
    height: 34px;
  }

  .switch input {
    opacity: 0;
    width: 0;
    height: 0;
  }

  .slider {
    position: absolute;
    cursor: pointer;
    top: 0;
    left: 0;
    right: 0;
    bottom: 0;
    background-color: rgb(219, 18, 18);
    -webkit-transition: 0.4s;
    transition: 0.4s;
  }

  .slider:before {
    position: absolute;
    content: "";
    height: 26px;
    width: 26px;
    left: 4px;
    bottom: 4px;
    background-color: white;
    -webkit-transition: 0.4s;
    transition: 0.4s;
  }

  input:checked + .slider {
    background-color: rgb(22, 167, 22);
  }

  /* input:focus + .slider {
      box-shadow: 0 0 1px rgb(22, 167, 22);
    } */

  input:checked + .slider:before {
    -webkit-transform: translateX(26px);
    -ms-transform: translateX(26px);
    transform: translateX(26px);
  }

  /* Rounded sliders */
  .slider.round {
    border-radius: 34px;
  }

  .slider.round:before {
    border-radius: 50%;
  }
</style>
