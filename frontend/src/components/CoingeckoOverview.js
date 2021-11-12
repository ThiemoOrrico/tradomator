import {Box} from "@mui/material";
import * as React from "react";
import CssBaseline from "@mui/material/CssBaseline";
import List from "@mui/material/List";
import CryptocardNew from "./CryptocardNew";


export default function CoingeckoOverview({ coins }) {


    return (
        <Box>
            <CssBaseline/>
            <List>

                {coins.map(coin => (
                    <CryptocardNew key={coin.id} coinData={coin}/>
                ))}

            </List>
        </Box>

    )
}