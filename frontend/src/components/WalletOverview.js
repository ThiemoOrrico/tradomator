import {Box} from "@mui/material";
import * as React from "react";
import CssBaseline from "@mui/material/CssBaseline";
import List from "@mui/material/List";
import WalletCard from "./WalletCard"


export default function WalletOverview({ wallet }) {


    return (
        <Box>
            <CssBaseline/>
            <List>

                {wallet?.balances?.map(balance => (
                    <WalletCard key={balance.asset} balance={balance}/>
                ))}

            </List>
        </Box>

    )
}