package kr.or.btf.web.web.controller;

import kr.or.btf.web.common.annotation.CurrentUser;
import kr.or.btf.web.domain.web.*;
import kr.or.btf.web.domain.web.enums.AnswerType;
import kr.or.btf.web.domain.web.enums.GraphDvType;
import kr.or.btf.web.services.web.*;
import kr.or.btf.web.web.form.*;
import lombok.RequiredArgsConstructor;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletResponse;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class GraphController extends BaseCont {

    private final GraphMasterService graphMasterService;
    private final GraphDataService graphDataService;

    @RequestMapping("/soulGod/graph/detail")
    public String list(Model model) {

        GraphMaster graphMaster = graphMasterService.loadByGraphDvTy(GraphDvType.MAIN_CYBER_BAR_CHART);
        model.addAttribute("form", graphMaster);

        List<GraphData> graphDataList = new ArrayList<>();
        if (graphMaster != null && graphMaster.getId() != null) {
            graphDataList = graphDataService.list(graphMaster.getId());
        }
        model.addAttribute("graphDataList", graphDataList);

        model.addAttribute("mc", "graph");
        return "/soulGod/graph/detail";
    }

    @RequestMapping("/soulGod/graph/modify")
    public String modify(Model model) {

        GraphMaster graphMaster = graphMasterService.loadByGraphDvTy(GraphDvType.MAIN_CYBER_BAR_CHART);
        model.addAttribute("form", graphMaster);

        List<GraphData> graphDataList = new ArrayList<>();
        if (graphMaster != null && graphMaster.getId() != null) {
            graphDataList = graphDataService.list(graphMaster.getId());
        }
        model.addAttribute("graphDataList", graphDataList);

        model.addAttribute("mc", "graph");
        return "/soulGod/graph/modify";
    }

    @PostMapping("/soulGod/graph/save")
    public String save(Model model,
                       @ModelAttribute GraphMasterForm graphMasterForm,
                       @ModelAttribute GraphDataForm graphDataForm) {

        graphDataForm.setGraphPid(graphMasterForm.getId());
        boolean save = graphDataService.save(graphDataForm);

        if (save) {
            model.addAttribute("mc", "graph");
            return "redirect:/soulGod/graph/detail";
        } else {
            model.addAttribute("altmsg", "실패했습니다.");
            model.addAttribute("locurl", "/soulGod/graph/modify");
            return "/message";
        }
    }

    @ResponseBody
    @PostMapping("/api/openData/graph/load/{id}")
    public String apiLoad(Model model,
                          @PathVariable(name = "id") Long id) throws JSONException {
        GraphMaster load = graphMasterService.load(id);
        if (load != null) {
            JSONObject rtnObj = new JSONObject();
            rtnObj.put("id", load.getId());
            rtnObj.put("nm", load.getGraphNm());
            rtnObj.put("ty", load.getGraphDvTy().name());

            JSONArray array = new JSONArray();
            List<GraphData> list = graphDataService.list(id);
            for (GraphData graphData : list) {
                if (graphData.getColNm() != null && !"".equals(graphData.getColNm())) {
                    JSONObject item = new JSONObject();
                    item.put("category", graphData.getColNm());
                    item.put("col1", graphData.getColValue1());
                    item.put("col2", graphData.getColValue2());
                    item.put("col3", graphData.getColValue3());
                    array.put(item);
                }
            }
            rtnObj.put("list", array);

            return rtnObj.toString();
        }
        return "{}";
    }
}
