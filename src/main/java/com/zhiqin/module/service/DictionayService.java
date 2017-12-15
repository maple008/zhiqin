package com.zhiqin.module.service;

import com.alibaba.fastjson.JSONObject;
import com.zhiqin.module.dto.DictionaryDto;
import com.zhiqin.module.sql.entity.TagCode;
import com.zhiqin.module.sql.entity.TagInfo;
import com.zhiqin.module.sql.repository.TagCodeRepository;
import com.zhiqin.module.sql.repository.TagInfoRepository;
import com.zhiqin.module.utils.BeanCopyUtils;
import com.zhiqin.module.utils.RespBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by maple on 2017/11/24.
 */
@Service
public class DictionayService {
    @Autowired
    private TagCodeRepository tagCodeRepository;
    @Autowired
    private TagInfoRepository tagInfoRepository;

    /**
     * 获取前三级
     *
     * @return
     */
    public RespBase<DictionaryDto> listDictionary() {
        RespBase<DictionaryDto> respBase = new RespBase<>();
        //第一级
        DictionaryDto Dto1 = new DictionaryDto();
        List<TagInfo> tagInfo = tagInfoRepository.findAllByParentId(0);
        TagInfo vo1 = tagInfo.get(0);
        BeanCopyUtils.copyProperties(vo1, Dto1);
        //第二级
        List<TagInfo> list2 = tagInfoRepository.findAllByParentId(Dto1.getId());
        List<DictionaryDto> ListDtos2 = new ArrayList<>();
        for (TagInfo vo2 : list2) {
            //第三级
            List<TagInfo> list3 = tagInfoRepository.findAllByParentId(vo2.getId());
            List<DictionaryDto> ListDtos3 = new ArrayList<>();
            for (TagInfo vo3 : list3) {
                List<TagInfo> list4 = tagInfoRepository.findAllByParentId(vo3.getId());
                DictionaryDto Dto3 = new DictionaryDto();
                BeanCopyUtils.copyProperties(vo3, Dto3);
                ListDtos3.add(Dto3);
            }
            DictionaryDto Dto2 = new DictionaryDto();
            BeanCopyUtils.copyProperties(vo2, Dto2);
            Dto2.setDictionaryDtos(ListDtos3);
            ListDtos2.add(Dto2);
        }
        Dto1.setDictionaryDtos(ListDtos2);
        respBase.setResult(Dto1);
        return respBase;
    }

    /**
     * 获取下一级的多个标签
     *
     * @param id
     * @return
     */
    public RespBase<List<DictionaryDto>> findNextTag(Integer id) {
        RespBase<List<DictionaryDto>> respBase = new RespBase<>();
        List<DictionaryDto> list = new ArrayList<>();
        List<TagInfo> tagInfo = tagInfoRepository.findAllByParentId(id);
        for (TagInfo vo1 : tagInfo) {
            DictionaryDto dto1 = new DictionaryDto();
            BeanCopyUtils.copyProperties(vo1, dto1);
            list.add(dto1);
        }
        respBase.setResult(list);
        return respBase;
    }

    //获取标签list
    private RespBase<List<DictionaryDto>> findTagInfo(Integer id) {
        RespBase<List<DictionaryDto>> respBase = new RespBase<>();
        List<TagInfo> list = tagInfoRepository.findAllByParentId(id);
        List<DictionaryDto> listDto = new ArrayList<>();
        for (TagInfo vo : list) {
            DictionaryDto dto1 = new DictionaryDto();
            BeanCopyUtils.copyProperties(vo, dto1);
            listDto.add(dto1);
        }
        respBase.setResult(listDto);
        return respBase;
    }

    /**
     * 获取所有分类
     *
     * @return
     */
    public RespBase<JSONObject> listAllType() {
        RespBase<JSONObject> respBase = new RespBase<>();
        List<TagCode> list11 = tagCodeRepository.findAllType(11);//年级
        List<TagCode> list9 = tagCodeRepository.findAllType(9);//分类
        List<TagCode> list8 = tagCodeRepository.findAllType(8);//品类
        List<TagCode> list7 = tagCodeRepository.findAllType(7);//科目
        List<TagCode> list6 = tagCodeRepository.findAllType(6);//版本
        List<TagCode> list3 = tagCodeRepository.findAllType(3);//地区
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("grade", this.addList(list11));
        jsonObject.put("classification", this.addList(list9));
        jsonObject.put("category", this.addList(list8));
        jsonObject.put("subject", this.addList(list7));
        jsonObject.put("edition", this.addList(list6));
        jsonObject.put("region", this.addList(list3));
        respBase.setResult(jsonObject);
        return respBase;
    }


    private List<TagCode> addList(List<TagCode> list) {
        List<TagCode> list_new = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            TagCode tagCode = list.get(i);
            if (i != 0) {
                list_new.add(tagCode);
            }
        }
        return list_new;
    }

    /**
     * 获取下一级的多个标签
     *
     * @param id
     * @return
     */
    public RespBase<List<DictionaryDto>> findNextByCodeId(Integer id) {
        RespBase<List<DictionaryDto>> respBase = new RespBase<>();
        List<DictionaryDto> list = new ArrayList<>();
        List<TagInfo> tagInfo = tagInfoRepository.findAllByCodeId(id);
        for (TagInfo vo1 : tagInfo) {
            DictionaryDto dto1 = new DictionaryDto();
            BeanCopyUtils.copyProperties(vo1, dto1);
            list.add(dto1);
        }
        respBase.setResult(list);
        return respBase;
    }


}
