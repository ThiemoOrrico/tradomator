import React, {useContext, useState} from 'react';
import {AuthContext} from "../context/AuthProvider";
import Box from "@mui/material/Box";
import TextField from "@mui/material/TextField";
import Button from "@mui/material/Button";
import {ThemeProvider} from "@mui/styles";
import themeLogin from "../styling/themeLogin";

const initialState = {
    username: "",
    password: ""
}

export default function Loginpage() {

    const [credentials, setCrededtials] = useState(initialState);
    const {login} = useContext(AuthContext)

    const handleChange = event => {
        setCrededtials({...credentials, [event.target.name]: event.target.value})
    }

    const handleSubmit = event => {
        event.preventDefault()
        login(credentials)
    }

    return (
        <ThemeProvider theme={themeLogin}>
            <form onSubmit={handleSubmit}>
                <Box
                    sx={{
                        '& > :not(style)': {m: 1, width: '25ch'},

                        display: 'grid',
                        gridTemplateColumns: 'auto',
                        gridTemplateRows: 'repeat(3, 3fr)',
                        gridTemplateAreas: `"userName passWord buttoN"`,
                    }}


                    autoComplete="off"
                >
                    <TextField
                        id="outlined-name"
                        name="username"
                        label="Userame"
                        value={credentials.username}
                        required={true}
                        onChange={handleChange}
                        sx={{gridArea: 'userName', justifyContent: "flex-start", mr: 2}}
                    />

                    <TextField
                        id="outlined-password"
                        name="password"
                        type={"password"}
                        label="Password"
                        value={credentials.password}
                        required={true}
                        onChange={handleChange}
                        sx={{gridArea: 'passWord',  mr: 2}}
                    />
                    <Box  sx={{gridArea: 'buttoN',  mr: 2}}>
                        <Button type="submit" onClick={handleSubmit} variant="outlined">Login</Button>
                    </Box>
                </Box>
            </form>
        </ThemeProvider>
    )
};

