<div class="switchContainer">
	
  <div class="container">

    <div class="container1">
      <h1>WLAN-Hotspot</h1>
      <label class="switch">
        <input id = "hotspot" type="checkbox" bind:checked={yes} />
        <span class="slider round" />
      </label>
    </div>

    <div class="container1">
      <h1>Bestehendes WLAN</h1>
      <p>SSID</p>
      <input class="eingabe" type="string" id="wlanSSID" disabled={!yes} bind:value={SSIDbestehend} />
      <p>Passwort</p>
      <input class="eingabe" type="string" id="wlanPasswort" disabled={!yes} bind:value={passwort} />
      <button id="connect" disabled={!yes} on:click={connectToWLAN}>Verbinden</button>
    </div>

    <div class="container1">
      <h1>Eigene SSID</h1>
      <input class="eingabe" type="string" id ="inputBtn" placeholder="Drehteller1" bind:value={ssid}>
    </div>
  </div>
</div>

<script>
  let ssid = "";
  let yes = true;
  let SSIDbestehend = "";
  let passwort = "";

  function connectToWLAN(){

  }
</script>

<style>
    #connect {
      transition: 0.2s ease-in-out;
      padding: 0.6em;
      border: none;
      color: #fff;
      background-color: #0e80c8;
      border-radius: 25px;
      margin: 2em;
      font-size: 18px;
      width: 70%;
    }

    #connect:hover {
      background-color: #1f1f1f;
    }

    #connect:disabled{
      background-color: #6b6b6b;
      color: #c1c1c1;
    }

    #connect:focus{
      outline: none;
      background-color: #39b3ff;
    }

  .switchContainer{
    padding-top: 1em;
    display: flex;
    justify-content: center;
    flex-direction: column;
    align-items: center;
  }

  .container1{
    display: flex;
    justify-content: center; 
    flex-direction: column;
    align-items: center;  
    margin-top: 3em; 
  }

  .eingabe{
    padding: 0.7em;
    width: 100%;
    margin-bottom: 1em;
    border: none;
    border-radius: 10px;
    transition: 0.1s ease-in-out;
  }

  .eingabe:focus{
    outline: 2px solid #0e80c8;
  }
   .switch{
    margin-top: 1em;
    position: relative;
    display:inline-flex;
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
  -webkit-transition: .4s;
  transition: .4s;
}

.slider:before {
  position: absolute;
  content: "";
  height: 26px;
  width: 26px;
  left: 4px;
  bottom: 4px;
  background-color: white;
  -webkit-transition: .4s;
  transition: .4s;
}

input:checked + .slider {
  background-color: rgb(22, 167, 22);
}

input:focus + .slider {
  box-shadow: 0 0 1px rgb(22, 167, 22);;
}

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
