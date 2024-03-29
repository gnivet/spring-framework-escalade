/*
 * Copyright 2002-2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.samples.escalade.service;

import java.util.Collection;
import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.dao.DataAccessException;
import org.springframework.samples.escalade.model.Area;
import org.springframework.samples.escalade.model.Comment;
import org.springframework.samples.escalade.model.Length;
import org.springframework.samples.escalade.model.NamedEntity;
import org.springframework.samples.escalade.model.Point;
import org.springframework.samples.escalade.model.Site;
import org.springframework.samples.escalade.model.SiteType;
import org.springframework.samples.escalade.model.Topo;
import org.springframework.samples.escalade.model.TopoBkg;
import org.springframework.samples.escalade.model.Visit;
import org.springframework.samples.escalade.model.Way;
import org.springframework.samples.escalade.model.Zone;
import org.springframework.samples.escalade.model.escaladeException;
import org.springframework.samples.escalade.repository.AreaRepository;
import org.springframework.samples.escalade.repository.CommentRepository;
import org.springframework.samples.escalade.repository.LengthRepository;
import org.springframework.samples.escalade.repository.PointRepository;
import org.springframework.samples.escalade.repository.SiteRepository;
import org.springframework.samples.escalade.repository.SiteTypeRepository;
import org.springframework.samples.escalade.repository.TopoBkgRepository;
import org.springframework.samples.escalade.repository.TopoRepository;
import org.springframework.samples.escalade.repository.UserRepository;
import org.springframework.samples.escalade.repository.WayRepository;
import org.springframework.samples.escalade.repository.ZoneRepository;
import org.springframework.stereotype.Service;
/**
 * Mostly used as a facade for all escalade controllers Also a placeholder
 * for @Transactional and @Cacheable annotations
 *
 * @author Guillaume Nivet
 * @param <TopoBkgs>
 *
 */

@Service
public class EscaladeServiceImpl<TopoBkgs> implements EscaladeService {


	private AreaRepository areaRepository;

	private CommentRepository commentRepository;

	private ZoneRepository zoneRepository;

	private SiteRepository siteRepository;
	private SiteTypeRepository siteTypeRepository;

	private WayRepository wayRepository;
	private LengthRepository lengthRepository;
	private PointRepository pointRepository;
	private TopoRepository topoRepository;
	private TopoBkgRepository topoBkgRepository;
	public EscaladeServiceImpl(

			AreaRepository areaRepository, CommentRepository commentRepository, ZoneRepository zoneRepository,
			SiteRepository siteRepository, SiteTypeRepository siteTypeRepository, WayRepository wayRepository,
			LengthRepository lengthRepository, PointRepository pointRepository, TopoRepository topoRepository,
			TopoBkgRepository topoBkgRepository, UserRepository userRepository)

	{
		this.areaRepository = areaRepository;
		this.commentRepository = commentRepository;
		this.zoneRepository = zoneRepository;
		this.siteRepository = siteRepository;
		this.siteTypeRepository = siteTypeRepository;
		this.wayRepository = wayRepository;
		this.lengthRepository = lengthRepository;
		this.pointRepository = pointRepository;
		this.topoRepository = topoRepository;
		this.topoBkgRepository = topoBkgRepository;

	}





	@Override
	@Transactional
	public Comment findCommentById(Integer id) throws DataAccessException{
		return commentRepository.findCommentById(id);
	}
//Comment findCommentById(Integer commentId)throws DataAccessException;
	@Override
	@Transactional
	public Collection<Comment> findCommentByName(String name) throws DataAccessException {
		// TODO Auto-generated method stub
		return commentRepository.findCommentByName(name);
	}

	@Transactional
	public void saveComment(Comment comment, org.springframework.samples.escalade.model.User user, Site site) throws DataAccessException {

		commentRepository.saveComment(comment);

	}





	@Override
	@Transactional
	public Topo findTopoById(Integer id) throws DataAccessException {
		// TODO Auto-generated method stub
		return topoRepository.findTopoById(id);
	}

	@Override
	@Transactional
	public Topo saveTopo(Topo topo) throws DataAccessException {
		// TODO Auto-generated method stub
		return this.topoRepository.saveTopo(topo);


	}





	@Override
	@Transactional
	public String findLoggedInusername() throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public void autoLogin(String username, String password) throws DataAccessException {
		// TODO Auto-generated method stub

	}

	@Override
	@Transactional
	public Collection<SiteType> findSiteTypes() throws DataAccessException {
		// TODO Auto-generated method stub
		return siteTypeRepository.findSiteTypes();
	}


	@Override
	@Transactional
	public Area saveArea(Area area) throws DataAccessException {

		return areaRepository.saveArea(area);
	}


	@Transactional
	public Area deleteAreaById(Area area) throws DataAccessException {

		return areaRepository.deleteAreaById(area.getId());
	}




	@Override
	@Transactional
	public NamedEntity updateArea(Area area) {
		return areaRepository.updateArea(area);

	}


	@Override
	@Transactional
	public Zone saveZone(Zone zone) throws DataAccessException {
		// TODO Auto-generated method stub
		return this.zoneRepository.saveZone(zone);

	}

	@Override
	@Transactional
	public Zone findZoneById(Integer zoneId) throws DataAccessException {
		// TODO Auto-generated method stub
		return zoneRepository.findZoneById(zoneId);
	}

	@Override
	@Transactional
	public Collection<Zone> findZoneByName(String name) throws DataAccessException {
		// TODO Auto-generated method stub
		return zoneRepository.findZoneByName(name);
	}


	@Override
	@Transactional
	public Site findSiteById(Integer id) throws DataAccessException {
		// TODO Auto-generated method stub
		return siteRepository.findSiteById(id);
	}

	@Override
	@Transactional
	public Area findAreaById(Integer id) throws DataAccessException {
		// TODO Auto-generated method stub
		return areaRepository.findAreaById(id);
	}



	@Override
	@Transactional
	public org.springframework.samples.escalade.model.User findUserByID(Integer id) throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public Collection<User> findUsers() throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Collection<SiteType> findSiteTypesCollection() throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	@Transactional
	public List<SiteType> findSiteTypesList() throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	@Transactional
	public SiteType findById(Integer id) throws DataAccessException {
		// TODO Auto-generated method stub
		return siteTypeRepository.findSiteTypeById(id);
	}

	@Override
	@Transactional
	public Way findWayById(Integer id) throws DataAccessException {
		// TODO Auto-generated method stub
		return wayRepository.findWayById(id);
	}



	@Override
	@Transactional
	public SiteType findSiteTypeById(Integer siteTypeId) {
		// TODO Auto-generated method stub
		return siteTypeRepository.findSiteTypeById(siteTypeId);
	}


	@Override
	@Transactional
	public Way saveway(Way way) {
		// TODO Auto-generated method stub
		return this.wayRepository.saveWay(way);
	}

	@Override
	@Transactional
	public Collection<Way> findWayByName(String name) {
		// TODO Auto-generated method stub
		return wayRepository.findWayByName(name);
	}

	@Transactional
	public Way finWayById(Integer wayId) {
		return wayRepository.findWayById(wayId);
	}



	@Override
	@Transactional
	public Site findSiteOwnedbyUser(String userName ) throws DataAccessException {
		// TODO Auto-generated method stub
		Integer id = null;
		return siteRepository.findSiteById(id);
	}




	@Override
	@Transactional
	public Collection<Area> findSiteByPostalCode(String postalcode) throws DataAccessException {
		// TODO Auto-generated method stub
		return areaRepository.findSiteByPostalcode(postalcode);
	}





	@Override
	@Transactional
	public Site saveSite(Site site) throws DataAccessException {
		return siteRepository.saveSite(site);
		// TODO Auto-generated method stub

	}










	@Override
	public NamedEntity updateZone(Zone zone) {
		// TODO Auto-generated method stub
		return zoneRepository.updateZone(zone);
	}





	@Override
	public Length saveLength(Length length) throws DataAccessException {

		// TODO Auto-generated method stub
		return this.lengthRepository.saveLength(length);
	}


	@Override
	public Point savePoint(Point point) throws DataAccessException {
		// TODO Auto-generated method stub
		return this.pointRepository.savePoint(point);
	}










	@Override
	public Length findLengthById(Integer lengthId) throws DataAccessException {
		// TODO Auto-generated method stub
		return lengthRepository.findLengthById(lengthId);
	}





	@Override
	@Transactional
	public Collection<Length> findLengthByName(String name) throws DataAccessException {
		// TODO Auto-generated method stub
		return lengthRepository.findLengthByName(name);
	}





	@Override
	public Point findPointById(Integer pointId) throws DataAccessException {
		// TODO Auto-generated method stub
		return pointRepository.findPointById(pointId);
	}





	@Override
	@Transactional
	public Collection<Point> findPointByName(String name) throws DataAccessException {
		// TODO Auto-generated method stub
		return pointRepository.findPointByName(name);
	}
    //GN

	@Override
	@Transactional
	public Collection<Site> findSiteByName(String name) throws DataAccessException {
		// TODO Auto-generated method stub
		return siteRepository.findSiteByName(name);
	}



	@Override
	@Transactional
	public Collection<SiteType> findSiteTypeByName(String name) throws DataAccessException {
		// TODO Auto-generated method stub
		return siteTypeRepository.findSiteTypeByName(name);
	}


	//GN

	//@Override
	//public Collection<Site> findSiteByName(String name) throws DataAccessException {
	//	// TODO Auto-generated method stub
	//	return null;
	//}





	@Override
	public void saveVisit(@Valid Visit visit) {
		// TODO Auto-generated method stub

	}





	@Override
	public Integer findCommentNumber(String username) throws DataAccessException {
		// TODO Auto-generated method stub
		return commentRepository.findCommentNumber(username);
	}



	public Integer findCountNumberCommentByUsername(String userName) throws DataAccessException {
		// TODO Auto-generated method stub
		return commentRepository.findCountNumberCommentByUsername(userName);
	}







	@Override
	public Integer findCountSiteOwnedByUsername(String userName) throws DataAccessException {
		// TODO Auto-generated method stub
		return siteRepository.findCountSiteOwnedByUsername(userName);
	}

	@Override
	public Collection<Comment> findCommentByUsername(String userName)throws DataAccessException{
		return commentRepository.findCommentByUsername(userName);

	}





	@Override
	public Comment saveComment(Comment comment) throws DataAccessException {
		return this.commentRepository.saveComment(comment);
		// TODO Auto-generated method stub

	}





	@Override
	public NamedEntity updateComment(Comment comment) {
		// TODO Auto-generated method stub
		return commentRepository.updateComment(comment);
	}





	@Override
	public SiteType saveSiteType(SiteType siteType) {
		return this.siteTypeRepository.saveSiteType(siteType);
		// TODO Auto-generated method stub

	}





	@Override
	public void updateComment(SiteType siteTypeToModify) throws DataAccessException {
		// TODO Auto-generated method stub

	}





	@Override
	public NamedEntity updateTopo(Topo topo) throws DataAccessException {
		// TODO Auto-generated method stub
		return topoRepository.updateTopo(topo);
	}





	@Override
	public Collection<Topo> findTopos() throws DataAccessException {
		// TODO Auto-generated method stub
		return topoRepository.findTopoByName();


	}






	




	@Override
	public Topo findTopoBookedBytopoBkgId(@NotNull Integer topoBkgId) throws DataAccessException {
		// TODO Auto-generated method stub
		return topoBkgRepository.findTopoBookedBytopoBkgId(topoBkgId);
	}










	@Override
	public List<Topo> findTopoByUserName(String userName) throws DataAccessException {
		// TODO Auto-generated method stub
		return topoRepository.findTopoByUserName(userName);
	}







	@Override
	public List<Topo> findTopoByUserId(Integer id) {
		// TODO Auto-generated method stub
		return topoRepository.findTopoByUserId(id);
	}





	@Override
	public org.springframework.samples.escalade.model.User findUserIdByUserName(String userName) {
		// TODO Auto-generated method stub
		return null;
	}






	@Override
	public List<TopoBkg> findTopoBkgById(Integer topoBkgId) throws DataAccessException {
		// TODO Auto-generated method stub
		return topoBkgRepository.findTopoBkgById(topoBkgId);
	}

	@Override
   	public TopoBkg findSingleTopoBkgById(Integer topoBkgId)throws DataAccessException {
		return topoBkgRepository.getAllTopoBkgById(topoBkgId);
	}





	@Override
	public Topo findTopoByNames(String name) {
		// TODO Auto-generated method stub
		return topoRepository.findTopoByNames(name);
	}





	@Override
	public TopoBkg updateTopoBkg(TopoBkg topoBkgToModify) throws escaladeException {
		// TODO Auto-generated method stub
		return topoBkgRepository.updateTopoBkg(topoBkgToModify);
	}





	@Override
	public TopoBkg saveTopoBkg(TopoBkg topoBkg) throws DataAccessException {
		// TODO Auto-generated method stub
		return topoBkgRepository.saveTopoBkg(topoBkg);
	}





	@Override
	public Collection<TopoBkg> findToposBkgs(Integer topo_id) throws DataAccessException {
		// TODO Auto-generated method stub
		return topoBkgRepository.findToposBkgs(topo_id);
	}





	@Override
	public Collection<Zone> findZones() throws DataAccessException {
		// TODO Auto-generated method stub
		return zoneRepository.findZones();
	}





	@Override
	public Collection<Area> listAreas() throws DataAccessException {
		// TODO Auto-generated method stub
		return areaRepository.listAreas();
	}





	@Override
	public Site updateSite(Site siteToModify) throws DataAccessException {
		// TODO Auto-generated method stub
		return siteRepository.updateSite(siteToModify);

	}








	@Override
	public Collection<TopoBkg> findTopoBkgByUserId(Integer userId) {
		// TODO Auto-generated method stub
		return topoBkgRepository.findTopoBkgByUserId(userId);
	}





	@Override
	public Collection<TopoBkg> findTopoBkgByUserId(org.springframework.samples.escalade.model.User userId) {
		// TODO Auto-generated method stub
		return null;
	}





	@Override
	public Collection<TopoBkg> findTopoBkgs() {
		// TODO Auto-generated method stub
		return topoBkgRepository.findTopoBkgs();
	}






	@Override
	public Collection<TopoBkg> findTopoBkgByUserName(String userName) {
		// TODO Auto-generated method stub
		return topoBkgRepository.findTopoBkgByUserName(userName);
	}

	@Override
	public Collection<Topo> findTopoAvailableByUserId(Integer id) {
		// TODO Auto-generated method stub
		return topoRepository.findTopoAvailableByUserId(id);
	}





	@Override
	public Topo findTopo() throws DataAccessException {
		// TODO Auto-generated method stub
		return topoRepository.findTopo();
	}











	@Override
	public Collection<TopoBkg> findTopoBkg(String name) {
		// TODO Auto-generated method stub
		return topoBkgRepository.findTopoBkg(name);
	}





	@Override
	public Collection<TopoBkg> findTopoBkgByIda(Integer id) throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}





	@Override
	public NamedEntity updateLength(Length siteToModify) throws DataAccessException {
		// TODO Auto-generated method stub
		return lengthRepository.updateLength(siteToModify);
	}





	@Override
	public NamedEntity updatePoint(Point point) throws DataAccessException {
		// TODO Auto-generated method stub
		return pointRepository.updatePoint(point);
	}




	@Transactional
	@Override
	public Collection<Zone> findZoneBySiteName(String name) throws DataAccessException {
		// TODO Auto-generated method stub
		return zoneRepository.findZoneBySiteName(name);
	}





	@Override
	public void deleteAreaById(Integer areaId) {
		// TODO Auto-generated method stub
		areaRepository.deleteAreaById(areaId);

	}



	@Override
	@Transactional
	public Collection<Site> ListSites() throws DataAccessException {
		// TODO Auto-generated method stub
		return siteRepository.findAll();
	}





	@Override
	public Collection<Way> findWayAvailableByName(String name) {
		// TODO Auto-generated method stub
		return wayRepository.findWayAvailableByName(name);
	}





	@Override
	public Integer findByUsername(String userName) throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}





	@Override
	public Collection<Topo> findTopoAvailableByName() throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}





	@Override
	public Collection<Way> findWayByUserName(String userName) throws DataAccessException {
		// TODO Auto-generated method stub
		return wayRepository.findWayByUserName(userName);
	}
}





