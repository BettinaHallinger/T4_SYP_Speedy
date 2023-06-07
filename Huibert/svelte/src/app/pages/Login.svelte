<script>
    import sjcl from 'sjcl'

    let email = "";
    let password = "";
    let passwordHash = "";
    let hasBeenClicked = false;

    /**
    * @param {string} email
    */
    
    function validateEmail(email) {
        var emailRegEx = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;  
        return emailRegEx.test(String(email).toLowerCase());
    }


    function setSessionUser() {
        sessionStorage.setItem("userName", email);
        console.log(window.sessionStorage.getItem("userName"));

        sessionStorage.setItem("userPass", passwordHash);
        console.log(window.sessionStorage.getItem("userPass"));
    }

    async function submitUser() {
        const data = {
            userName: sessionStorage.getItem("userName"),
            userPass: sessionStorage.getItem("userPass")
        };

        const response = await fetch("/submit-user", {
            method: "POST",
            headers: {"Content-Type": "application/json"},
            body: JSON.stringify(data),
        });

        if (response.ok) {
            const result = await response.text();
            // Handle the returned message from Java
            console.log(result);
        } else {
            // Handle the error case
            console.error('Error occurred during request');
        }
    }

    function hashPassword() {

        const userPass = password;
        const myBitArray = sjcl.hash.sha256.hash(userPass);
        const passHash = sjcl.codec.hex.fromBits(myBitArray);
        console.log(passHash);
        passwordHash = passHash;
    }

    function handleSubmission() {
    hasBeenClicked = true;
        if (email !== "" && isValidPassword) {
            // Send data somewhere
            hashPassword();
            setSessionUser();
            alert("submitted");
            submitUser();
        }
    }

    $: isValidPassword = password.length >= 4;
    
</script>
    
    
    
    
    <div class = "textField">
        <h1>Login</h1>
        <div class="input-wrapper">
            <input class="eingabe" type="email" bind:value={email} placeholder="Email"/>
<!--            <p class="validation-error">Invalid email</p>-->
<!--            <p class="validation">Valid email</p>-->
        </div>
        
        <div class="input-wrapper">
            <input class="eingabe" type="password" bind:value={password} placeholder="Password"/>
                
            {#if hasBeenClicked && !isValidPassword}
            <p class="validation-error">Please enter a longer password</p>
                {/if}
            {#if isValidPassword}
            <p class="validation">Password is save.</p>
            {/if}
        </div>

        <button class="btnSubmit" on:click={handleSubmission} >Login</button>
    </div>

    <style>


    
.input-wrapper {
    flex: 1;
    text-align: left;
    padding-bottom: 20px;
}
  
.validation-error {
    color: rgb(176, 30, 30);
    margin-top: 5px;
}
    
.validation{
    color: green;
    margin-top: 5px;
}
    
h1 {
    text-align: center;
}
    
</style>