import React, { useState } from 'react';
import { Link } from 'react-router-dom';
import useStyles from './styles';
import logo from '../../images/logo.png';
import IconButton from "@material-ui/core/IconButton";
import { Toolbar, Typography, AppBar, InputBase } from "@material-ui/core";
import MenuIcon from '@material-ui/icons/Menu';
import SearchIcon from '@material-ui/icons/Search';
import { SidebarData } from './SidebarData';
import * as AiIcons from 'react-icons/ai';

const Navbar = () => {
	const classes = useStyles();
	const [showSidebar, setShowSidebar] = useState(false);

	const toggleSidebar = () => {
		setShowSidebar(!showSidebar);
	}

	return (
		<>
			<AppBar className={classes.appBar}>
				<Toolbar>
					<IconButton
						edge="start"
						className={classes.menuButton}
						color="inherit"
						aria-label="open drawer"
					>
						<MenuIcon onClick={toggleSidebar}/>
					</IconButton>
					<img src={logo} alt="icon" height="50" />
					<Typography className={classes.title} variant="h6">
						&nbsp; (((CringeCinema)))
					</Typography>
					<div className={classes.search}>
						<div className={classes.searchIcon}>
							<SearchIcon />
						</div>
						<InputBase
							placeholder="Search…"
							classes={{
								root: classes.inputRoot,
								input: classes.inputInput,
							}}
							inputProps={{ 'aria-label': 'search' }}
						/>
					</div>
				</Toolbar>
			</AppBar>
			<nav className={showSidebar ? `${classes.navMenu} ${classes.active}` : `${classes.navMenu}`}>
				<ul className={classes.navMenuItems} onClick={toggleSidebar}>
					{SidebarData.map((item, index) => {
						return (
							<li key={index} className={classes.navText}>
								<Link to={item.path}>
									{item.icon}
									&nbsp;<span>{item.title}</span>
								</Link>
							</li>
						);
					})}
				</ul>
			</nav>
		</>
	);
}

export default Navbar;