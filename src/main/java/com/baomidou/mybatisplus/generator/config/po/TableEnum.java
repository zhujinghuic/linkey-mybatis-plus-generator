/*
 * Copyright (c) 2011-2020, baomidou (jobob@qq.com).
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * <p>
 * https://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.baomidou.mybatisplus.generator.config.po;

import com.baomidou.mybatisplus.generator.config.rules.IColumnType;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * 枚举字段信息
 *
 * @author zjh
 * @since 2021年1月16日
 */
@Data
@Accessors(chain = true)
public class TableEnum {

    private String name;
    private String comment;
    private List<EnumField> enumFields;


}
