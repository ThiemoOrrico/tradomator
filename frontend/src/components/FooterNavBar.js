import Box from "@mui/material/Box";
import * as React from "react";

export default function FooterNavBar() {
    return (

            <Box
                sx={{
                    alignContent: 'flex-end',
                    width: '100%',

                    color: '#fff',
                    '& > .MuiBox-root > .MuiBox-root': {
                        p: 1,
                        borderRadius: 0,
                    },
                }}
            >
                <Box
                    sx={{
                        display: 'grid',
                        gridTemplateColumns: 'repeat(3, 1fr)',

                        gridTemplateRows: 'auto',
                        gridTemplateAreas: `"footerLeft footerCenter footerRight"`,
                    }}
                >
                    <Box sx={{gridArea: 'footerLeft', bgcolor: 'primary.main'}}>FooterLeft</Box>
                    <Box sx={{gridArea: 'footerCenter', bgcolor: 'primary.main'}}>FooterCenter</Box>
                    <Box sx={{gridArea: 'footerRight', bgcolor: 'primary.main'}}>FooterRight</Box>

                </Box>

            </Box>


    )
}


