import React, { useEffect, useState } from 'react';
import { Link } from 'react-router-dom';
import useStyles from './styles';
import logo from '../../images/logo.png';
import IconButton from "@material-ui/core/IconButton";
import { Toolbar, Typography, AppBar, InputBase, Button } from "@material-ui/core";
import MenuIcon from '@material-ui/icons/Menu';
import SearchIcon from '@material-ui/icons/Search';
import { SidebarData } from './SidebarData';
import { useDispatch } from 'react-redux';
import { getPosts, filterPosts } from '../../actions/posts';

const Navbar = () => {
	const classes = useStyles();
	const dispatch = useDispatch();
	const [showSidebar, setShowSidebar] = useState(false);
	const [search, setSearch] = useState("");

	const toggleSidebar = () => {
		setShowSidebar(!showSidebar);
	}

	useEffect(() => {
		dispatch(getPosts());
		if (search) {
			dispatch(filterPosts(search));
		}
	}, [search])

	return (
		<>
			<AppBar className={classes.appBar}>
				<Toolbar>
					<IconButton
						edge="start"
						className={classes.menuButton}
						color="inherit"
						aria-label="open drawer"
						onClick={toggleSidebar}
					>
						<MenuIcon />
					</IconButton>
					<Link to="/">
						<img src={logo} alt="icon" height="50" />
					</Link>
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
							value={search}
							onChange={(e) => setSearch(e.target.value)}
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